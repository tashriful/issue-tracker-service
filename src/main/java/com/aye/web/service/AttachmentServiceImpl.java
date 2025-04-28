package com.aye.web.service;

import com.aye.web.model.Attachment;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
public class AttachmentServiceImpl implements AttachmentService{

    @Autowired
    private GridFsTemplate template;

    @Autowired
    private GridFsOperations operations;

    @Override
    public String addFile(MultipartFile upload) throws IOException {

        DBObject metadata = new BasicDBObject();
        metadata.put("fileSize", upload.getSize());

        // Automatically closes InputStream after use
        try (InputStream inputStream = upload.getInputStream()) {
            Object fileID = template.store(inputStream, upload.getOriginalFilename(), upload.getContentType(), metadata);

            if (fileID != null && !fileID.toString().isEmpty()) {
                return fileID.toString();
            } else {
                throw new IOException("File not saved or file ID not found");
            }
        }
    }

    @Override
    public Attachment downloadFile(String id) throws IOException {

        GridFSFile gridFSFile = template.findOne( new Query(Criteria.where("_id").is(id)) );

        Attachment loadFile = new Attachment();

        if (gridFSFile != null && gridFSFile.getMetadata() != null) {
            loadFile.setId(gridFSFile.getObjectId());
            loadFile.setFileName( gridFSFile.getFilename() );

            loadFile.setContentType( gridFSFile.getMetadata().get("_contentType").toString() );

            loadFile.setSize((Long) gridFSFile.getMetadata().get("fileSize"));

            loadFile.setContent( IOUtils.toByteArray(operations.getResource(gridFSFile).getInputStream()));
        }

        return loadFile;
    }
}
