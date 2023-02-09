package gov.iti.jets.server.controller;


import gov.iti.jets.server.network.ClientInvitation;
import gov.iti.jets.server.network.ServerInvitation;
import gov.iti.jets.server.service.InvitationService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class InvitationController extends UnicastRemoteObject implements ServerInvitation {
    InvitationService invitationService;
    public InvitationController() throws RemoteException {
        super();
        invitationService = new InvitationService();
    }

    @Override
    public void sendInvitation(String senderID, ClientInvitation clientInvitation, String receiverID) throws RemoteException {
        invitationService.sendInvitation(senderID, clientInvitation, receiverID);
    }

    @Override
    public void acceptInvitation(String id)  throws RemoteException  {

    }

    @Override
    public void rejectInvitation(String id)  throws RemoteException {

    }
}