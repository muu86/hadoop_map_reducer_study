package myhadoop.support;

import org.apache.hadoop.io.Text;

// 항공 데이터 csv 를 분절해서 필요한 컬럼 정보를 분석하는 클래스
public class AirlinePerformanceParser {
	// 예) 1987, 1, .........  -> 콤마 로 분할하여 클래스 필드에 세팅
	
	// 필드
	private int year;
	private int month;
	private String uniqueCarrier;
	private float departureDelayTime = 0;
	private float arrivalDelayTime = 0;
	private float distance = 0;
	
	// 생성자
	public AirlinePerformanceParser(Text line) {	// a, b, c
		// 한줄의 csv 를 읽어서 분석 후 필드에 세팅
		try {
			String[] columns = line.toString().split(",");	// [a, b, c]
			year = Integer.parseInt(columns[0]);
			month = Integer.parseInt(columns[1]);
			uniqueCarrier = columns[5];
			
			if (columns[16].length() != 0) {
				departureDelayTime = Float.parseFloat(columns[16]); // 출발 지연 시간 정보
			}
			
			if (columns[26].length() != 0) {
				arrivalDelayTime = Float.parseFloat(columns[26]); // 도착 지연 시간 정보
			}
			
			if (columns[37].length() != 0) {
				distance = Float.parseFloat(columns[37]);	// 운항 거리
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getYear() {
		return year;
	}
	public int getMonth() {
		return month;
	}
	public String getUniqueCarrier() {
		return uniqueCarrier;
	}
	public float getDepartureDelayTime() {
		return departureDelayTime;
	}
	public float getArrivalDelayTime() {
		return arrivalDelayTime;
	}
	public float getDistance() {
		return distance;
	}
	
	
}
