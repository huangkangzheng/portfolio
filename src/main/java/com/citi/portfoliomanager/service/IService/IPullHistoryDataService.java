package com.citi.portfoliomanager.service.IService;

import java.io.File;

public interface IPullHistoryDataService {
     void pullDataToDB(String dataRealPath);
     boolean pullDataToDB(String name,int type,File file);
}
