package com.github.dwiechert.tinyweb;

import java.util.List;
import java.util.Map;

public interface View {
	String render(Map<String, List<String>> model);
}
