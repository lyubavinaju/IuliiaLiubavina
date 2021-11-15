package com.epam.tc.hw4.utils;

import io.qameta.allure.Attachment;

public class AttachmentUtils {
    @Attachment(type = "image/png", value = "Page screenshot")
    public static byte[] makeScreenShotAttachment(final byte[] source) {
        return source;
    }
}
