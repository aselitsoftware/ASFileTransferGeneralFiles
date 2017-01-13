package ru.aselit;

public enum FileTransferCommandEnum {

	ftcNone(0), ftcAuthorize(1), ftcFileInfo(2), ftcUploadStart(3), ftcUpload(4), ftcDownloadStart(5), ftcDownload(6);
	
	private final int value;
	
	private FileTransferCommandEnum(int value) {
		
		this.value = value;
	}
	
	public int toInt() {
		
		return value;
	}
	
	public static FileTransferCommandEnum fromInt(int value) {
		
		int i;
		
		FileTransferCommandEnum []v = values();
		
		for (i = 0; i < v.length; i++)
			if (v[i].ordinal() == value)
				return v[i];
		return ftcNone;
	}
}
