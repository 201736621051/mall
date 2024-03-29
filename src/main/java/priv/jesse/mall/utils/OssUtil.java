package priv.jesse.mall.utils;

import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.OSSClient;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * @Auther: wdd
 * @Date: 2019/10/10 21:07
 * @Description:
 */
@Component
public class OssUtil {
    public String accessKeyId = "LTAI4FxtgTG9eBLHrkBsGC4d";

    public String accessKeySecret = "n7PimBiLqJUsmSppr7xtd12L3y7uop";

    public String endpoint = "oss-cn-beijing.aliyuncs.com";

    public String bucketName = "springbootmall";

    public static OSSClient client;


    public OSSClient initClient(){
        if(null==client){
            ClientConfiguration conf = new ClientConfiguration();
            conf.setConnectionTimeout(5000);
            conf.setMaxErrorRetry(10);
            client = new OSSClient("http://" + endpoint, accessKeyId, accessKeySecret,conf);
        }
        return client;
    }

    /**
     * 图片上传
     * @param file
     * @param folder
     * @return
     */
    public String uploadImage(MultipartFile file, String folder){
        initClient();
        //创建文件名
        if(StringUtils.isEmpty(folder)){
            folder = "image";
        }
        String fileName = folder+"/"+ UUID.randomUUID()+ file.getOriginalFilename();
        try {
           client.putObject(bucketName,fileName,file.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "https://" + bucketName + "." + endpoint + "/" + fileName;
    }


}
