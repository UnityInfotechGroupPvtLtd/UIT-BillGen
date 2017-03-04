package handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import ui.ChekForAdminUI;
import ui.TelcoBOM;
import util.SConstants;

public class HomeButtonHandler implements ActionListener {

	public HomeButtonHandler(JDialog owner)
	{
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		switch (arg0.getActionCommand())
		{
			case SConstants.BILL_GEN_WIN_NAME:
			{
				new TelcoBOM(new javax.swing.JDialog());
			}
			
			break;
			case SConstants.ADMIN_WIN_NAME:
			{
				new ChekForAdminUI(new javax.swing.JDialog());
				//new AdminHomeUI(new javax.swing.JDialog());
				/*}
				else
				{
					new PopupDialogs("Please Check Admin Credentials.", PopupDialogs.ERROR_MESSAGE);
				}*/
			}
			
			break;
			
			

		default:
			break;
		}
	}

}
