package sampleshop.api;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
@RequestMapping(value = "/api")
public class MainApi {

	@GetMapping("/main")
	public Map<String, Object> main(@RequestParam(value = "name", defaultValue = "World") String name) {
		Map<String, Object> map = new HashMap<>();
		map.put("subject", "hello world");
		map.put("top", top());

		return map;
	}

	@GetMapping("/main/top")
	public Collection<Slide> top() {
		List<Slide> lists = new LinkedList<>();
		for (int i=1; i<11; i++) {
			String subject = "node"+i;
			lists.add(Slide.toSlide(subject, ""));
		}

		return lists;
	}

	@Data
	public static class Slide {
		String subject;
		String image;

		public static Slide toSlide(String...args) {
			Slide slide = new Slide();
			slide.subject = args[0];
			slide.image = args[1];

			return slide;
		}
	}
}
