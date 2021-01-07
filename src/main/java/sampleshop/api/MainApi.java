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
	public Map<String, Object> main(@RequestParam(value = "name", defaultValue = "World") String name) throws InterruptedException {
		Map<String, Object> map = new HashMap<>();
		map.put("subject", "hello world");
		map.put("corner1", corner1());
		map.put("corner2", corner2());

		Thread.sleep(200);
		
		return map;
	}

	@GetMapping("/main/corner1")
	public Collection<Slide> corner1() {
		List<Slide> lists = new LinkedList<>();
		for (int i=1; i<16; i++) {
			String subject = "slide "+i;
			if (i%3 == 0) {
				lists.add(Slide.toSlide(Integer.toString(i), subject, "video", "//vjs.zencdn.net/v/oceans.mp4", "2500"));
			} else {
				lists.add(Slide.toSlide(Integer.toString(i), subject, "image", "/images/sample/goods/"+i, "2500"));
			}
			
		}
		
		return lists;
	}
	
	@GetMapping("/main/corner2")
	public Collection<Slide> corner2() {
		List<Slide> lists = new LinkedList<>();
		for (int i=1; i<8; i++) {
			String subject = "slide "+i;
			lists.add(Slide.toSlide(Integer.toString(i), subject, "image", "/images/sample/goods/"+i, "13000"));
		}
		
		return lists;
	}

	@Data
	public static class Slide {
		String id;
		String text;
		String sourceType; // image or video
		String src;
		String price;
		String salesCode = "";
		String headText; 

		public static Slide toSlide(String...args) {
			Slide slide = new Slide();
			slide.id = args[0];
			slide.text = args[1];
			slide.sourceType = args[2];
			slide.src = args[3];
			slide.price = args[4];

			return slide;
		}
	}
}
