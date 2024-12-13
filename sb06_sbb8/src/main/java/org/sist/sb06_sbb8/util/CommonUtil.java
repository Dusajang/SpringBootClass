package org.sist.sb06_sbb8.util;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.stereotype.Component;

@Component
public class CommonUtil {

	// 일반문자열을 서식이 있는 문자열로 변환해주는 메서드
	public String markdown(String markdown) {
		
		Parser parser = Parser.builder().build();
		Node document = parser.parse(markdown);
		
		HtmlRenderer htmlRenderer = HtmlRenderer.builder().build();
		
		return htmlRenderer.render(document);
		
		
	}
}
