package com.maneater.foundation.uitl;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {

	public static boolean copy(InputStream inputStream, OutputStream outPutStream) throws IOException {

		byte[] data = new byte[10240];
		int dataSize = 0;

		try {
			while ((dataSize = inputStream.read(data)) != -1) {
				outPutStream.write(data, 0, dataSize);
			}
		} finally {
			close(inputStream);
			close(outPutStream);
		}
		return true;
	}

	public static void close(Closeable closeable) throws IOException {
		if (closeable != null) {
			closeable.close();
		}
	}

}
