package PS.admin.controller;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import PS.admin.model.retentionInfo;
import PS.admin.service.ViewRetentionService;

public class ViewRetentionController extends BaseFunctionController{

	public void index() {
		super.baseIndex();
	}
	
	@Override
	protected boolean templateFunctionMethod(final Integer serverId) {
		final String startDate = getPara("startDate");
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<List<retentionInfo>> future = executor.submit(new Callable<List<retentionInfo>>() {
			public List<retentionInfo> call() throws Exception {
				return ViewRetentionService.service.viewRetention(startDate, serverId);
			}
		});
		List<retentionInfo> rif = null;
		try {
			rif = future.get(5000, TimeUnit.MILLISECONDS);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("futureException", e);
			future.cancel(true);
			executor.shutdownNow();
			return false;
		}
	    setAttr("startDatere", startDate);
		setAttr("viewRetention", true);
		setAttr("retentionlist", rif);
		return true;
	}

}
