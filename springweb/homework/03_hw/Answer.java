package springweb.z01_vo;

public class Answer {
	private String answer1;
	private String answer2;
	private String quest1;
	private String quest2;
	private String trueAnswer1;
	private String trueAnswer2;
	
	public String getTrueAnswer1() {
		return trueAnswer1;
	}
	public void setTrueAnswer1(String trueAnswer1) {
		this.trueAnswer1 = trueAnswer1;
	}
	public String getTrueAnswer2() {
		return trueAnswer2;
	}
	public void setTrueAnswer2(String trueAnswer2) {
		this.trueAnswer2 = trueAnswer2;
	}
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Answer(String answer1, String answer2) {
		super();
		this.answer1 = answer1;
		this.answer2 = answer2;
	}
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public String getQuest1() {
		return quest1;
	}
	public void setQuest1(String quest1) {
		this.quest1 = quest1;
	}
	public String getQuest2() {
		return quest2;
	}
	public void setQuest2(String quest2) {
		this.quest2 = quest2;
	}
	
	
	
}
