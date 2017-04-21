package uit.billgen.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import uit.billgen.uiviews.ChekForAdminUI;
import uit.billgen.uiviews.MonthlyBOMUI;
import uit.billgen.uiviews.SearchUI;
import uit.billgen.uiviews.TelcoBOM;
import uit.billgen.util.SConstants;

public class HomeButtonHandler implements ActionListener {

	public HomeButtonHandler(JDialog owner)
	{
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		switch (arg0.getActionCommand())
		{
			case SConstants.TAL_BILL_BTN_STRING:
			{
				new TelcoBOM(new javax.swing.JDialog(),SConstants.TAL_BILL_BTN_STRING);
			}
			
			break;
			case SConstants.ADMIN_BTN_STRING:
			{
				new ChekForAdminUI(new javax.swing.JDialog(),SConstants.ADMIN_BTN_STRING);
			}
			
			break;
			case SConstants.MONTHLY_BOM_BTN_STRING:
			{
				new MonthlyBOMUI(new javax.swing.JDialog(),SConstants.MONTHLY_BOM_BTN_STRING);
			}
			
			break;
			case SConstants.HISTORY_BTN_STRING:
			{
				new SearchUI(new javax.swing.JDialog(),SConstants.SEARCH_STRING);
			}
			
			break;
			case SConstants.UPDATE_BTN_STRING:
			{
				//new SearchUI(new javax.swing.JDialog(),SConstants.UPDATE_BTN_STRING);
				//update
			}
			
			break;
			
			

		default:
			break;
		}
	}

}
