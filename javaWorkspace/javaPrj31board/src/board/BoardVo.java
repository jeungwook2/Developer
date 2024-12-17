package board;

public class BoardVo {
	
	private String title;
	private String content;
	private String writer;
	
	@Override
	public String toString() {
		return "BoardVo [title=" + title + ", content=" + content + ", writer=" + writer + "]";
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
}