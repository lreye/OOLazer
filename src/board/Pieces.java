package board;

public enum Pieces {
	
	L("L"),T("T"),Z("Z"),B("B"),M("M"),P("P"),K("K"),BEAM("BEAM");
	
	private String value;

	
	private Pieces(String value)
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

