package br.com.unialfa.calculadora.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.jfoenix.controls.JFXButton;
import javafx.scene.control.Label;

public class CalculadoraController {

	@FXML
	private Label lblScreen;

	@FXML
	private JFXButton btnTres;

	@FXML
	private JFXButton btnCinco;

	@FXML
	private JFXButton btnNove;

	@FXML
	private JFXButton btnDivide;

	@FXML
	private JFXButton btnZero;

	@FXML
	private JFXButton btnUm;

	@FXML
	private JFXButton btnQuatro;

	@FXML
	private JFXButton btnDois;

	@FXML
	private JFXButton btnSeis;

	@FXML
	private JFXButton btnSete;

	@FXML
	private JFXButton btnIgual;

	@FXML
	private JFXButton btnOito;

	@FXML
	private JFXButton btnMenos;

	@FXML
	private JFXButton btnVezes;

	@FXML
	private JFXButton btnMais;

	@FXML
	private JFXButton btnLimpa;

	@FXML
	private StringBuilder valores = new StringBuilder();
	private double n1 = 0.0, n3;
	private String operator;

	@FXML
	void PressValues(ActionEvent event) {
		valores.append(((JFXButton) event.getSource()).getText());
		lblScreen.setText(String.valueOf(Double.parseDouble(valores.toString())));
	}

	@FXML
	void ButtonEquals(ActionEvent event) {
		Contas();
		Print("");
	}

	@FXML
	void ButtonMinus(ActionEvent event) {
		if (n1 != 0 & valores.length() != 0) {
			Contas();
		}

		if (!ValoresEstaVazio()) {
			operator = "-";
			n1 = Double.valueOf(valores.toString());
			Print(operator);
			valores.setLength(0);
		}
	}

	@FXML
	void ButtonMulti(ActionEvent event) {
		if (n1 != 0 & valores.length() != 0) {
			Contas();
		}

		if (!ValoresEstaVazio()) {
			operator = "*";
			n1 = Double.valueOf(valores.toString());
			Print(operator);
			valores.setLength(0);
		}
	}

	@FXML
	void ButtonSum(ActionEvent event) {
		if (n1 != 0 && valores.length() != 0) {
			Contas();
		}

		if (!ValoresEstaVazio()) {
			operator = "+";
			n1 = Double.valueOf(valores.toString());
			Print(operator);
			valores.setLength(0);
		}
	}

	@FXML
	void ButtonDivi(ActionEvent event) {
		if (n1 != 0 & valores.length() != 0) {
			Contas();
		}

		if (!ValoresEstaVazio()) {
			operator = "/";
			n1 = Double.valueOf(valores.toString());
			Print(operator);
			valores.setLength(0);
		}
	}

	@FXML
	void ButtonClear(ActionEvent event) {
		valores.setLength(0);
		n1 = 0;
		Print("");
	}

	@FXML
	void ButtonDot(ActionEvent event) {
		if (ValoresEstaVazio()) {
			return;
		}
		if(!valores.toString().contains(".")) {
			valores.append(((JFXButton) event.getSource()).getText());
			lblScreen.setText(String.valueOf(Double.parseDouble(valores.toString())));
		}else {
			return;
		}
	}

	void Print(String operador) {
		lblScreen.setText(valores.toString() + operador);
	}

	private boolean ValoresEstaVazio() {
		return valores.length() == 0;
	}

	void Contas() {
		Double resultado = 0.0;
		if (ValoresEstaVazio()) {
			return;
		} else {

			if (n1 == 0) {
				return;
			}
			n3 = Double.valueOf(valores.toString());
			if (operator.equals("+")) {
				resultado = n1 + n3;
			}

			if (operator.equals("-")) {
				resultado = n1 - n3;
			}

			if (operator.equals("/")) {
				resultado = n1 / n3;
			}

			if (operator.equals("*")) {
				resultado = n1 * n3;
			}

		}
		valores.setLength(0);
		valores.append(resultado);
		n1 = 0;
	}
}
