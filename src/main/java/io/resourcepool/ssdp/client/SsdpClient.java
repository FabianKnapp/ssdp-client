package io.resourcepool.ssdp.client;

import io.resourcepool.ssdp.client.impl.SsdpClientImpl;
import io.resourcepool.ssdp.client.util.Utils;
import io.resourcepool.ssdp.model.DiscoveryListener;
import io.resourcepool.ssdp.model.DiscoveryRequest;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.List;

/**
 * @author Loïc Ortola on 11/03/2016.
 */
public abstract class SsdpClient {

  /**
   * Discover specific devices of particular ServiceType.
   *  @param req      the discovery request
   * @param callback the discovery listener
   * @param networkInterfaces
   */
  public abstract void discoverServices(DiscoveryRequest req, DiscoveryListener callback, List<NetworkInterface> networkInterfaces);

  public void discoverServices(DiscoveryRequest req, DiscoveryListener callback) throws SocketException {
    discoverServices(req, callback, Utils.getLoopbackMulticastInterfaces());
  }


  /**
   * Stop discovery.
   */
  public abstract void stopDiscovery();

  /**
   * @return new instance of SsdpClient.
   */
  public static SsdpClient create() {
    return new SsdpClientImpl();
  }

}
