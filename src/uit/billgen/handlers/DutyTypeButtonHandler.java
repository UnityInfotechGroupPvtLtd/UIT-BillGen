package uit.billgen.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uit.billgen.beans.DutyType;
import uit.billgen.datamodel.DutyTypeDataModel;
import uit.billgen.exceptions.PopupDialogs;
import uit.billgen.uiviews.AddDutyTypeUI;
import uit.billgen.uiviews.EditDutyType;
import uit.billgen.util.Dao;
import uit.billgen.util.SConstants;

public class DutyTypeButtonHandler implements ActionListener {

	private JDialog parent = null;
	public DutyTypeButtonHandler(JDialog owner)
	{
		this.parent = owner;
	}

	@Override
	public void actionPerformed(ActionEvent event)
	{
		if(event.getActionCommand().equalsIgnoreCase(SConstants.ADD_BTN_STRING))
		{
			Map<String, Object> dutyTypeComponentMap = AddDutyTypeUI.getDutyTypeUIComponent();
			
			JPanel enterHours = (JPanel) dutyTypeComponentMap.get("enterHours");
			JTextField lblHoursValue = (JTextField) enterHours.getComponent(2);
			String hoursValue = lblHoursValue.getText();
			
			JPanel enterKmValue = (JPanel) dutyTypeComponentMap.get("enterKmValue");
			JTextField lblKMValue = (JTextField) enterKmValue.getComponent(2);
			String kmValue = lblKMValue.getText();
			
			JPanel enterPkgRate = (JPanel) dutyTypeComponentMap.get("enterPkgRate");
			JTextField lblPkgValue = (JTextField) enterPkgRate.getComponent(2);
			String pkgValue = lblPkgValue.getText();
			
			JPanel enterExtraKmRate = (JPanel) dutyTypeComponentMap.get("enterExtraKmRate");
			JTextField lblextraKmRate = (JTextField) enterExtraKmRate.getComponent(2);
			String extraKmRateValue = lblextraKmRate.getText();
			
			JPanel panelCustomer = (JPanel) dutyTypeComponentMap.get("panelCustomer");
			@SuppressWarnings("rawtypes")
			JComboBox comboCustomer = (JComboBox) panelCustomer.getComponent(2);
			String cName = comboCustomer.getSelectedItem().toString();
			
			JPanel panelVehicle = (JPanel) dutyTypeComponentMap.get("panelVehicle");
			@SuppressWarnings("rawtypes")
			JComboBox comboVehicle = (JComboBox) panelVehicle.getComponent(2);
			String vName = comboVehicle.getSelectedItem().toString();
			if(hoursValue.isEmpty() ||  cName.isEmpty() || kmValue.isEmpty() || pkgValue.isEmpty() || vName.isEmpty() || extraKmRateValue.isEmpty())
			{
				new PopupDialogs(SConstants.MSG_PLZ_FILL_ALL_THE_FIELDS,PopupDialogs.ERROR_MESSAGE);
			}
			else
			{
				DutyTypeDataModel model = new DutyTypeDataModel();
				int uid = model.noOfDutyTypes();
				DutyType dutyType = new DutyType((uid+1),Integer.parseInt(hoursValue), Integer.parseInt(kmValue), Double.parseDouble(pkgValue),Double.parseDouble(extraKmRateValue), cName, vName);
				//new Dao().addDutyType(dutyType);
				model.addDutyType(dutyType);
				new PopupDialogs(SConstants.MSG_ADDED_SUCCESSFULLY,PopupDialogs.PLAIN_MESSAGE);
				parent .dispose();
			}
			
			
			
		}
		if(event.getActionCommand().equalsIgnoreCase(SConstants.EDIT_BTN_STRING))
		{
			Map<String, Object> map = EditDutyType.getEditDutyTypeUIComponent();
			JPanel panelCombo = (JPanel) map.get("panelDutyType");
			@SuppressWarnings("rawtypes")
			JComboBox comboDutyType = (JComboBox) panelCombo.getComponent(2);
			DutyType dutyType = new DutyTypeDataModel().getDutyType(comboDutyType.getSelectedItem().toString());
			
			JPanel enterHours = (JPanel) map.get("enterHours");
			JTextField textHours = (JTextField) enterHours.getComponent(2);
			int hours = Integer.parseInt(textHours.getText());
			
			JPanel enterKmValue = (JPanel) map.get("enterKmValue");
			JTextField textKm = (JTextField) enterKmValue.getComponent(2);
			int km = Integer.parseInt(textKm.getText());
			
			JPanel enterPkgRate = (JPanel) map.get("enterPkgRate");
			JTextField textpkgRate = (JTextField) enterPkgRate.getComponent(2);
			double rate = Double.parseDouble(textpkgRate.getText());
			
			JPanel enterExtraKmRate = (JPanel) map.get("enterExtraKmRate");
			JTextField textExtraKmRate = (JTextField) enterExtraKmRate.getComponent(2);
			double extraKmRate = Double.parseDouble(textExtraKmRate.getText());
			
			JPanel customer = (JPanel) map.get("customer");
			@SuppressWarnings("unchecked")
			JComboBox<String> textCustomer = (JComboBox<String>) customer.getComponent(2);
			String cName = textCustomer.getSelectedItem().toString();
			
			JPanel vehicle = (JPanel) map.get("vehicle");
			@SuppressWarnings("unchecked")
			JComboBox<String> textVehicle = (JComboBox<String>) vehicle.getComponent(2);
			String vName = textVehicle.getSelectedItem().toString();
			
			DutyType newDutyType = new DutyType(dutyType.getUid(), hours, km, rate, extraKmRate, cName, vName);
			DutyTypeDataModel objDutyTypeDataModel = new DutyTypeDataModel();
			objDutyTypeDataModel.updateAttributeValue(newDutyType);
			new Dao().editDutyType(newDutyType);
			new PopupDialogs(SConstants.MSG_UPDATED_SUCCESSFULLY, PopupDialogs.PLAIN_MESSAGE);
			parent.dispose();
		}
		if(event.getActionCommand().equalsIgnoreCase(SConstants.CANCEL_BTN_STRING))
		{
			parent.dispose();
		}
	}

}