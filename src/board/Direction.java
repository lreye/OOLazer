package board;

public enum Direction {

	N("N"),E("E"),S("S"),W("W"),None("?");
	
	private String value;
	
	private Direction(String value)
	{
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
