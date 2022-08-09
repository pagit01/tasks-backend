package br.ce.wcaquino.taskbackend.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

public class DateUtilsTest {

	@Test
	public void deveRetornarTrueParaDatasFuturas() {
		LocalDate data = LocalDate.of(2023, 1, 1);
		assertTrue(DateUtils.isEqualOrFutureDate(data));
	}
	
	@Test
	public void deveRetornarTrueParaDataAtual() {
		LocalDate data = LocalDate.now();
		assertTrue(DateUtils.isEqualOrFutureDate(data));
	}

	@Test
	public void deveRetornarFalseParaDatasPassadas() {
		LocalDate data = LocalDate.of(2000, 1, 1);
		assertFalse(DateUtils.isEqualOrFutureDate(data));
	}
}
