package com.epam.tc.hw6.service.utils;

import io.qameta.allure.Attachment;

public class AttachmentUtils {
    @Attachment(type = "image/png", value = "Page screenshot")
    public static byte[] makeScreenShotAttachment(final byte[] source) {
        return source;
    }
}
