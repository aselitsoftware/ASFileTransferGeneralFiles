package ru.aselit;

public enum FileModeEnum {

	fmNone(0), fmUpload(1), fmDownload(2);
	
	private final int value;
	
	private FileModeEnum(int value) {
		
		this.value = value;
	}
	
	public int toInt() {
		
		return value;
	}
	
	public static FileModeEnum fromInt(int value) {
		
		int i;
		
		FileModeEnum []v = values();
		
		for (i = 0; i < v.length; i++)
			if (value == v[i].ordinal())
				return v[i];
		return fmNone;
	}

}
