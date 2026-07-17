package PrintMaster;

// Interface: Checking printer availability before print order proceeds
// Mocking for calculatePrintingCharge
public interface printerAvailabilityService {
	boolean isPrinterAvailable(String paperSize, String printType);
}
