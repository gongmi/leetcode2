package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
		public static void main(String[] args) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String point;
			try {
				point = br.readLine();
				String x = br.readLine();
				String y = br.readLine();
				String work = br.readLine();
				String huaFei = br.readLine();
				int taxiNum = Integer.parseInt(point);
				int[] xs = new int[taxiNum];
				int[] ys = new int[taxiNum];
				String[] hengs = x.trim().split(" ");
				for(int i = 0; i < taxiNum; i++) {
					xs[i] = Integer.parseInt(hengs[i]);
				}
				String[] zongs = y.trim().split(" ");
				for(int i = 0; i < taxiNum; i++) {
					ys[i] = Integer.parseInt(zongs[i]);
				}
				String[] gxy = work.trim().split(" ");
				int gx = Integer.parseInt(gxy[0]);
				int gy = Integer.parseInt(gxy[1]);
				String[] units = huaFei.trim().split(" ");
				int walkTime = Integer.parseInt(units[0]);
				int taxiTime = Integer.parseInt(units[1]);
				int[] times = new int[taxiNum+1];
				for(int i = 0; i < taxiNum; i++) {
					times[i] = walkTime * (Math.abs(xs[i]) + Math.abs(ys[i]))
							+ taxiTime * (Math.abs(xs[i] - gx) + Math.abs(ys[i] - gy));
				}
				times[taxiNum] = walkTime * (Math.abs(gx) + Math.abs(gy));
				int min = times[0];
				for(int i = 1; i <= taxiNum; i++) {
					if(times[i] < min) {
						min = times[i];
					}
				}
				System.out.println(min);
			} catch (IOException e) {
				e.printStackTrace();
			}
}
}