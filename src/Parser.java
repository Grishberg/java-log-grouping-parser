
import java.util.*;public class Parser 
{
	private final HashMap<String, RecordSet> records = new HashMap<>();
	
	void process(String line) {
		Record rec = new Record(line);
		RecordSet recordSet = records.get(rec.name);
		if(recordSet == null){
			recordSet = new RecordSet(rec.name);
			records.put(rec.name, recordSet);
		}
		
		switch(rec.eventType) {
			case START:
				recordSet.start = rec;
				break;
			case CALL:
				recordSet.call = rec;
				rec.timestamp -= recordSet.start.timestamp;
				break;
			case GET:
				recordSet.get = rec;
				rec.timestamp -= recordSet.start.timestamp;
				break;
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{\n");
		for(Map.Entry<String, RecordSet> eset: records.entrySet()){
			sb.append(" name: ");
			sb.append(eset.getKey());
			sb.append("\n  start at: ");
			RecordSet rs = eset.getValue();
			sb.append(rs.start.timestamp);
			
			sb.append("\n  call: ");
			sb.append(rs.call.timestamp);
			
			sb.append("\n  get: ");
			sb.append(rs.get.timestamp);
			sb.append("\n");
			
				
		}
		sb.append("}");
		return sb.toString();
	}
	
}
