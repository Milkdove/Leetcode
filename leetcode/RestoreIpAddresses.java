package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 * <p>
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 */
public class RestoreIpAddresses {
    List<String> res = new ArrayList<>();
    int[] segments = new int[4];

    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 0);
        return res;
    }

    public void dfs(String s, int segId, int segStart) {
        if (segId == 4) {//四个IP
            if (segStart == s.length()) {
                StringBuffer ipAddr = new StringBuffer();
                for (int i = 0; i < 4; i++) {
                    ipAddr.append(segments[i]);
                    if (i != 3) {
                        ipAddr.append(".");
                    }
                }
                res.add(ipAddr.toString());
            }
            return;
        }
        if (segStart == s.length()) {
            return;
        }
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); segEnd++) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 255) {
                segments[segId] = addr;
                dfs(s, segId + 1, segStart + 1);
            } else {
                break;
            }
        }
    }

    @Test
    public void test() {
        List<String> res2 = restoreIpAddresses("19216811");
        System.out.println(res2);
    }
}
