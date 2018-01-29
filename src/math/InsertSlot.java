package math;
public class InsertSlot {
	public int solution(int[] P, int K) {
	        /*
	         * use 'days' to record each flower's blooming day
	         * we need to find a group that satisfies 
	         * days[i] < days[left] && days[i] < days[right]
	         *
	         * special case: set the days[0] == days[N + 1] to be MAX_INT
	         */

		int n = P.length;
	         int[] days = new int[n + 2];
	         
	         // corner case: if K > n return -1
	         if (K > n)
	            return -1;
	            
	        days[0] = days[n + 1] = Integer.MAX_VALUE;
	        for (int i = 0; i < n; ++i) {
	        		int flower_idx = P[i];
	        		days[flower_idx] = i + 1;
	        }
	        
		/* 
		 * find continuous k flowers that are blooming after 2 boundary flowers
		 * 
		 * always maintaining invariant of the sliding window:  days[i]< left && days[i] < right 
		 * (for all i, s.t. left < i < right)
		 */
		int left = 0, right = K + 1, res = -1;
		for (int i = 0; right < n + 2; ++i) {
			int blooming_day = days[i];
			if (blooming_day > days[left] || blooming_day >= days[right]) {
				// make ith flower new boundary
				if (i == right) {
					// e.g. flower[i] blooms at day 5, then the last day should be 5 - 1 = 4 
					int this_day = Math.min(days[left], days[right]) - 1;
					if (this_day > res)
						res = this_day;
				}
				left = i;
				right = i + K + 1;
			}
		}
		return res;
	}
}
