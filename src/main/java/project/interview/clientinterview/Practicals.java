package project.interview.clientinterview;

public class Practicals {

	public static void main(String[] args) {
		int a[] = { 1, 4, 1, 9, 100, 7, 100 };
		boolean flag = false;
		for (int i = 0; i < a.length; i++) {
			for (int j = 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					flag = true;
					break;
				}
			}
			if (flag) {
				break;
			}
		}
	}

}
