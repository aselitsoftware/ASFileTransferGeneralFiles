package ru.aselit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileTransferBuffer {

	private byte[] buffer = null;
	
	private static final Logger log = LogManager.getLogger(FileTransferBuffer.class);
	
	
	public void write(byte []inBuf, int size) {

		if (size <= 0)
			return;
		
		if (null == buffer) {
		
			buffer = new byte[size];
			System.arraycopy(inBuf, 0, buffer, 0, size);
		} else {
		
			byte[] newBuf = new byte[buffer.length + inBuf.length];
			System.arraycopy(buffer, 0, newBuf, 0, buffer.length);
			System.arraycopy(inBuf, 0, newBuf, buffer.length, inBuf.length);
			buffer = newBuf;
		}
	}
	
	/**
	 * Reading data block from buffer. 
	 * @return
	 */
	public byte[] readBlock() {
	
		byte[] block = null;
		try {
		
			if (null != buffer) {
//				throw new Exception("Buffer is null.");
				if (buffer.length < Integer.BYTES)
					throw new Exception("Buffer has wrong length.");
//				get block size (decode first four bytes)
				int size = ((buffer[3] << 24) + (buffer[2] << 16) + (buffer[1] << 8) + (buffer[0] << 0));
				if ((size <= 0) || (buffer.length < (Integer.BYTES + size)))
					throw new Exception("Block has wrong length.");
				
//				get block data
				block = new byte[size];
				System.arraycopy(buffer, Integer.BYTES, block, 0, size);
				
//				delete block from buffer
				size += Integer.BYTES;
				if (buffer.length > size) {
					
					byte[] newBuf = new byte[buffer.length - size];
					System.arraycopy(buffer, size, newBuf, 0, buffer.length - size);
					buffer = newBuf;
				} else
					buffer = null;
			}
				
		} catch (Exception ex) {
			
			log.error(ex);
		}
		return block;
	}
}
