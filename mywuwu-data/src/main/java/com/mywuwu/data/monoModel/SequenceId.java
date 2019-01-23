package com.mywuwu.data.monoModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
/**
 * @Auther: 梁乐乐
 * @Date: 2019/1/23 14:36
 * @Description: 该 pojo 类主要为每个集合记录自增的序列
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "sequence")
public class SequenceId {
    @Id
    private String Id;
    @Field("collName")
    private String collName;
    @Field("seqId")
    private long seqId;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCollName() {
        return collName;
    }

    public void setCollName(String collName) {
        this.collName = collName;
    }

    public long getSeqId() {
        return seqId;
    }

    public void setSeqId(long seqId) {
        this.seqId = seqId;
    }
}