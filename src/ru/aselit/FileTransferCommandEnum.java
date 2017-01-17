package ru.aselit;

public enum FileTransferCommandEnum {

	ftcNone(0), ftcWaitResponse(1), ftcAuthorize(2), ftcFileInfo(3), ftcUploadStart(4),
		ftcUpload(5), ftcDownloadStart(6), ftcDownload(7);
	
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
	
	public static String toString(FileTransferCommandEnum state) {
		
		switch (state) {
		case ftcWaitResponse:	return "Waiting for a response";
		case ftcAuthorize:		return "Authorize";
		case ftcFileInfo:		return "Request file info";
		case ftcUploadStart:	return "Start upload";
		case ftcUpload:			return "Uploading";
		case ftcDownloadStart:	return "Start download";
		case ftcDownload:		return "Downloading";
		default:				return "Unknown";
		}
	}
}
