package com.eltex;


import com.eltex.models.Attachment;
import com.eltex.models.AttachmentType;
import com.eltex.service.WallService;

public class Main {

    public static void main(String[] args) {
        final var service = new WallService();
        service.like();
        service.setAuthor("Автор");
        service.setAttachment(new Attachment(null, AttachmentType.VIDEO));
        System.out.println(service.getPost().attachment());
        System.out.println(service.getPost());
        System.out.println(service.getPost().original());
    }
}