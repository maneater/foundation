package com.maneater.foundation.service.impl;

import com.maneater.foundation.entity.GraphModel;
import com.maneater.foundation.entity.GraphSupplier;
import com.maneater.foundation.repository.GraphModelRepository;
import com.maneater.foundation.repository.SupplierRepository;
import com.maneater.foundation.uitl.FileUtil;
import com.maneater.foundation.uitl.ZipPropertiesUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2015/11/18 0018.
 */
@Service
public class SupplierService {
    @Resource
    private SupplierRepository supplierRepository;
    @Resource
    private GraphModelRepository graphModelRepository;


    public List<GraphSupplier> listAllSupplier() {
        return supplierRepository.findAll();
    }

    public GraphSupplier findSupplierById(Long id) {
        return supplierRepository.findOne(id);
    }

    public GraphSupplier createSupplier(GraphSupplier graphSupplier) {
        return supplierRepository.saveAndFlush(graphSupplier);
    }

    public GraphSupplier updateSupplier(GraphSupplier graphSupplier) {
        return supplierRepository.saveAndFlush(graphSupplier);
    }

    public boolean changeEnableStatus(Long supplierId, boolean value) {
        return supplierRepository.setEnableStatus(supplierId, value) != null;
    }

    /***************/

    public List<GraphModel> listGraphModelBySupplier(long supplierId) {
        return graphModelRepository.findBySupplierId(supplierId);
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
                for (GraphModel graphModel : modelList) {
                    properContent.append(ZipPropertiesUtil.createZipProper(graphModel));
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
}
