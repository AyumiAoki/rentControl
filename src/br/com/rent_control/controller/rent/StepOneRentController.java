package br.com.rent_control.controller.rent;

import javax.swing.JOptionPane;
import br.com.rent_control.model.dao.CustomerDao;
import br.com.rent_control.model.vo.Customer;
import br.com.rent_control.model.vo.Rent;
import br.com.rent_control.view.components.CheckDate;
import br.com.rent_control.view.rent.*;

/**
 * @author ayumi
 *
 */

public class StepOneRentController {

	private StepOneRentScreen stepOneRentScreen;
	private CustomerDao customerDao;

	public StepOneRentController(StepOneRentScreen stepOneRentScreen) {
		this.stepOneRentScreen = stepOneRentScreen;
		customerDao = new CustomerDao();
	}

	public void searchButtonClicked() {
		String cpf = stepOneRentScreen.getCpfField().getTextField().getText();
		Customer customer = customerDao.getCustomerByCpf(cpf);

		if (!cpf.equals("")) {
			if (customer != null) {
				stepOneRentScreen.setCustomer(customer);
				stepOneRentScreen.showFields();
			} else {
				stepOneRentScreen.removeFieldsPanel();
				JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
			}
		} else {
			stepOneRentScreen.removeFieldsPanel();
			JOptionPane.showMessageDialog(null, "Preencha o campo!");
		}
	}

	public void returnButtonClicked() {
		stepOneRentScreen.getMenuPanel().getContentPanel().removeAll();
		stepOneRentScreen.getMenuPanel().getContentPanel()
				.add(new RentalScreen(stepOneRentScreen.getFrameRentControl(), stepOneRentScreen.getMenuPanel()));
		stepOneRentScreen.getMenuPanel().getContentPanel().revalidate();
		stepOneRentScreen.getMenuPanel().getContentPanel().repaint();
	}

	public void proceedButtonClicked() {
		String withdrawalDate = stepOneRentScreen.getWithdrawalDate().getTextField().getText();
		String deliveryDate = stepOneRentScreen.getDeliveryDate().getTextField().getText();

		CheckDate checkDate = new CheckDate();

		if (!withdrawalDate.equals("") && !deliveryDate.equals("")) {
			if (withdrawalDate.length() > 8 && deliveryDate.length() > 8) {
				JOptionPane.showMessageDialog(null, "A data precisa estar no formato 00000000");
			} else if(!withdrawalDate.matches("\\d+") && !deliveryDate.matches("\\d+")) {
				JOptionPane.showMessageDialog(null, "Insira apenas números");
			}else {
				int withdrawalDay = Integer.parseInt(withdrawalDate.substring(0, 2));
				int withdrawalMonth = Integer.parseInt(withdrawalDate.substring(2, 4));
				int withdrawalYear = Integer.parseInt(withdrawalDate.substring(4, 8));

				int deliveryDay = Integer.parseInt(deliveryDate.substring(0, 2));
				int deliveryMonth = Integer.parseInt(deliveryDate.substring(2, 4));
				int deliveryYear = Integer.parseInt(deliveryDate.substring(4, 8));
				
				int dailyAmount = new CheckDate().calculateDifferenceDays(withdrawalDay, withdrawalMonth, withdrawalYear, deliveryDay, deliveryMonth, deliveryYear);

				if (!checkDate.checkDate(withdrawalDay, withdrawalMonth, withdrawalYear)) {
					JOptionPane.showMessageDialog(null, "Data de retirada inválida");
				} else if (!checkDate.checkDate(deliveryDay, deliveryMonth, deliveryYear)) {
					JOptionPane.showMessageDialog(null, "Data de devolução inválida");
				} else if (!checkDate.checkBiggerDate(withdrawalDay, withdrawalMonth, withdrawalYear, deliveryDay,
						deliveryMonth, deliveryYear)) {
					JOptionPane.showMessageDialog(null, "A data de devolução tem que ser maior que a de retirada");
				} else {
					Rent rent = new Rent();
					rent.setIdCar(stepOneRentScreen.getIdCar());
					rent.setCpfCustomer(stepOneRentScreen.getCustomer().getCpf());
					rent.setWithdrawalDate(withdrawalDate);
					rent.setPickUpLocation(stepOneRentScreen.getPickUpLocation().getComboBox().getSelectedItem().toString());
					rent.setDeliveryDate(deliveryDate);
					rent.setDeliveryLocation(stepOneRentScreen.getReturnLocation().getComboBox().getSelectedItem().toString());
					
					stepOneRentScreen.getMenuPanel().getContentPanel().removeAll();
					stepOneRentScreen.getMenuPanel().getContentPanel().add(new StepTwoRentScreen(stepOneRentScreen.getFrameRentControl(), stepOneRentScreen.getMenuPanel(), rent, dailyAmount, stepOneRentScreen.getDailyCost()));
					stepOneRentScreen.getMenuPanel().getContentPanel().revalidate();
					stepOneRentScreen.getMenuPanel().getContentPanel().repaint();
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
		}
	}
}