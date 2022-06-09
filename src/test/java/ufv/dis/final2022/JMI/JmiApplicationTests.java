package ufv.dis.final2022.JMI;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class JmiApplicationTests {

	@Test
	void contextLoads() {

	}

	@Test
	public void getDirIP() {
		ObjetoBuscarIP ip = new ObjetoBuscarIP("192.168.1.1");
		String esperado = "192.168.1.1";
		String obtenido = ip.getIp();
		assertEquals(esperado, obtenido);
	}

}

class TestIP{
	@Test
	public void getDirIP() {
		ObjetoBuscarIP ip = new ObjetoBuscarIP("192.168.1.1");
		String esperado = "192.168.1.1";
		String obtenido = ip.getIp();
		assertEquals(esperado, obtenido);
	}
}
