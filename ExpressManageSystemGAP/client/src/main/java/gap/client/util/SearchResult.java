package gap.client.util;

public class SearchResult {
	private String name;
	private String keyword;
	private int[] matchIndex;
	
	public SearchResult(String name,String keyword,int[] matchIndex){
		this.name = name;
		this.keyword = keyword;
		this.matchIndex = matchIndex;
	}

	public String getName() {
		return name;
	}

	public String getKeyword() {
		return keyword;
	}

	public int[] getMatchIndex() {
		return matchIndex;
	}




}
