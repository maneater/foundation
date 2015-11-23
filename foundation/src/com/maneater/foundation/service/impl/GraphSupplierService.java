package com.maneater.foundation.service.impl;

import com.maneater.foundation.entity.GraphModel;
import com.maneater.foundation.entity.GraphSupplier;
import com.maneater.foundation.repository.GraphModelRepository;
import com.maneater.foundation.repository.GraphModelSupplierRepository;
import com.maneater.foundation.repository.GraphRoomRepository;
import com.maneater.foundation.uitl.FileUtil;
import com.maneater.foundation.uitl.ZipPropertiesUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2015/11/19 0019.
 */
@Service
public class GraphSupplierService {
    @Resource
    private GraphModelSupplierRepository graphModelSupplierRepository;

    @Resource
    private GraphModelRepository graphModelRepository;

    public List<GraphSupplier> listAll() {
        return graphModelSupplierRepository.findAll();
    }

    public GraphSupplier findById(Long id) {
        return graphModelSupplierRepository.findOne(id);
    }

    public GraphSupplier save(GraphSupplier supplier) {
        if (supplier.getId() != null) {//update
            GraphSupplier dbItem = graphModelSupplierRepository.findOne(supplier.getId());
            boolean needSync = dbItem != null && !dbItem.getName().equals(supplier.getName());
            supplier = graphModelSupplierRepository.saveAndFlush(supplier);
            if (supplier != null && needSync) {
                //categoryName change
                graphModelRepository.syncSupplierName(supplier.getId(), supplier.getName());

            }
        } else {//create
            supplier = graphModelSupplierRepository.saveAndFlush(supplier);
        }
        return supplier;
    }

    public boolean changeEnable(Long id, boolean value) {
        return graphModelSupplierRepository.setEnableStatus(id, value) != null;
    }

    public String createAppletZip(String baseDirPath, Long[] modelIds) {

        //TODO check null
        String dirPath = FileUtil.createDir(baseDirPath, "zip_properties");

        List<Long> ids = Arrays.asList(modelIds);
        List<GraphModel> modelList = graphModelRepository.findAll(ids);
        if (modelIds != null) {
            String propertiesFileName = createPropertiesFileName(Arrays.toString(modelIds));

            String filePath = checkPropertiesFile(propertiesFileName);

            filePath = dirPath + "/" + propertiesFileName + ".zip";

            if (!CollectionUtils.isEmpty(modelList)) {
                StringBuilder properContent = new StringBuilder();
                int index = 0;
                for (GraphModel graphModel : modelList) {
                    properContent.append(ZipPropertiesUtil.createZipProper(graphModel, ++index));
                    properContent.append("\r\n");
                }
                boolean result = FileUtil.zipStringToFile(properContent.toString(), "PluginFurnitureCatalog.properties", filePath);
                return "zip_properties/" + propertiesFileName + ".zip";
            }
        }
        return null;
    }

    private static String createPropertiesFileName(String srcName) {
        return FileUtil.string2MD5(srcName);
    }

    /**
     * check already created;if created return the filePath,else null;
     *
     * @param propertiesFileName
     * @return
     */
    private String checkPropertiesFile(String propertiesFileName) {
        return null;
    }

    public List<GraphSupplier> listAllSupplierByEnable(boolean enable) {
        return graphModelSupplierRepository.findByEnable(enable);
    }

}
