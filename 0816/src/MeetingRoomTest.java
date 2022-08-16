import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class MeetingRoomTest {

	static class Meeting implements Comparable<Meeting> {
		int start, end; // 회의 시작, 종료 시간

		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting m) { // 종료시간 기준 오름차순, 종료시간이 같다면 시작시간 기준 오름차순
			return this.end != m.end ? this.end - m.end : this.start - m.start;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(in.readLine()); // 총 회의 개수

		Meeting[] meetings = new Meeting[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		List<Meeting> result = getSchedule(meetings);
		for(Meeting meeting:result) {
			System.out.println(meeting.start + " "+ meeting.end);
		}
	}

	private static List<Meeting> getSchedule(Meeting[] meetings) {
		// 모든 회의를 종료시간 기준 오름차순, 종료시간이 같다면 시작시간 기준 오름차순 정렬
		List<Meeting> result = new ArrayList<Meeting>();
		Arrays.sort(meetings);
		result.add(meetings[0]); // 첫 회의 스케줄에 추가
		for (int i = 1, size = meetings.length; i < size; i++) {
			if(result.get(result.size()-1).end <= meetings[i].start) {
				result.add(meetings[i]);
			}
		}
		return result;
	}

}
