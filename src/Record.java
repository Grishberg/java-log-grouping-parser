public class Record
{
	final String name;
	final EventType eventType;
	 long timestamp;
	
	public Record(String line){
		String[] lst = line.split(",");
		this.name = lst[1].trim();
		String evtype = lst[0].toUpperCase().trim();
		this.eventType = EventType.valueOf( evtype );
		this.timestamp = Long.valueOf(lst[2].trim());
	}
}
