package sampleshop.web;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * thymeleaf page에 기본적용할 global variable 정의
 * 
 * @author Park Chulhui <charles@plgrim.com>
 *
 */
@ControllerAdvice
public class GlobalControllerAdvice {
	@Autowired
	Environment env;


	@ModelAttribute("env")
	public Environment environment() {
		return env;
	}

	@ModelAttribute("nodeJsProxyEnabled")
	public boolean nodeJsProxyEnabled() {
		String proxy = StringUtils.defaultString(env.getProperty("nodejs.proxy"));
		if ("enabled".equals(proxy)) {
			return true;
		} else
			return false;
	}
}
