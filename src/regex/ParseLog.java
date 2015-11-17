package regex;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseLog {
	public static void main(String[] args) throws IOException {
		String log = "2015-11-06 10:29:45.093427 mon.0 172.168.9.241:6789/0 388084 : cluster [INF] pgmap v197573: 704 pgs: 704 active+clean; 67549 MB data, 198 GB used, 6455 GB / 6654 GB avail; 180 kB/s rd, 43047 B/s wr, 33 op/s";
		Pattern pattern = Pattern
				.compile("^((\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}).\\d{2,}) ([^ ]+) ([^ ]+ \\d{2,}) : (.+)$");

		Matcher matcher = pattern.matcher(log);

		if (matcher.find()) {
			System.out.println(matcher.group(1));
			System.out.println(matcher.group(3));
			System.out.println(matcher.group(4));
			System.out.println(matcher.group(5));
		}

		String name = "/hadoop/sourceFile/JN1/result/tmp/CA{{tour-hotel-search-query}}-r-0000";
		Pattern caPattern = Pattern.compile("CA\\{\\{(.+)\\}\\}");
		matcher = caPattern.matcher(name);
		matcher.find();
		System.out.println(matcher.group(1));

		Pattern pattern111 = Pattern
				.compile("^\\+?([1-9][0-9]*|0)(B|KB|MB|GB|TB|PB|EB)?$");
		matcher = pattern111.matcher("10737418242");
		if (matcher.find()) {
			System.out.println(matcher.group(2));
		}else{
			System.out.println("notMatch'");
		}
		
        try {
			System.out.println(new ParseLog().parseToByte("200B"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	final BigDecimal dataInterval = new BigDecimal(1024);
	final String[] byteUnits = { "B", "KB", "MB", "GB", "TB", "PB", "EB" };
	final BigDecimal longMaxValue = new BigDecimal(Long.MAX_VALUE);

	// 将2000MB 500GB这样格式的数据转化为B为单位的long值，如果超过long的表示范围 也就是 2^63-1 抛出异常
	public long parseToByte(String dataValue) throws Exception {
		Pattern pattern = Pattern
				.compile("^\\+?([1-9][0-9]*|0)(B|KB|MB|GB|TB|PB|EB)?$");
		Matcher matcher = pattern.matcher(dataValue);
		if (matcher.find()) {
			BigDecimal data = new BigDecimal(matcher.group(1));
			String unit = matcher.group(2);
			if (unit == null) {
				unit = "B";
			}
			for (int i = 0; i < byteUnits.length; i++) {
				if (!unit.equals(byteUnits[i])) {
					data = data.multiply(dataInterval);
					if (data.compareTo(longMaxValue) > 0) {
						break;
					}
				} else {
					break;
				}
			}
			if (data.compareTo(longMaxValue) > 0) {
				throw new Exception("data out of range");
			}
			return data.longValue();
		} else {
			throw new Exception("param wrong format");
		}
	}
}
