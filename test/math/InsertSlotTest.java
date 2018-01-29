package math;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class InsertSlotTest {
	InsertSlot solution = new InsertSlot();
	
	@Test
	public void test1() {
		int n = 5, K = 1;
		int[] nums = {3, 1, 5, 4, 2};
		assertEquals(4, solution.solution(nums, K));
	}
	
	@Test
	public void test2() {
		int n = 5, K = 2;
		int[] nums = {3, 1, 5, 4, 2};
		assertEquals(-1, solution.solution(nums, K));
	}

}
