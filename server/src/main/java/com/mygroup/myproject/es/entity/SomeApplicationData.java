package com.mygroup.myproject.es.entity;

import lombok.Data;
import org.springframework.data.annotation.Version;
import org.springframework.data.elasticsearch.annotations.*;
import org.springframework.data.elasticsearch.core.join.JoinField;

import javax.persistence.Id;

/**
 * @ClassName: TestEntity
 * @Description:
 * @Author 吴小田
 * @Date 2022/1/9
 */

//@Setting(
//        sortFields = { "secondField", "firstField" },
//        sortModes = { Setting.SortMode.max, Setting.SortMode.min },
//        sortOrders = { Setting.SortOrder.desc, Setting.SortOrder.asc },
//        sortMissingValues = { Setting.SortMissing._last, Setting.SortMissing._first })
@Document(indexName="books",createIndex = true)
@Setting(shards =3,replicas =2)
@Data
public class SomeApplicationData {
    //对应_id，是String类型，即使是5000这个数值，看ES里存储最终确认得出。
    @Id
    private String id;

    ////name如果是text类型就不能排序。必须是keyword。
    @Field(type = FieldType.Keyword)
    private String name;

    @Field(type = FieldType.Text)
    private String summary;

    @Field(type = FieldType.Integer)
    private Integer price;

    //my favorite food hot water cold porridge
    @Field(analyzer = "ik_max_word",type = FieldType.Text)
    private String my_text;

    //对应_version
    @Version
    private Long version;

////嵌套ChildItem
//    @Field(type = FieldType.Object)
//    private ChildItem childItem;


//    @JoinTypeRelations(
//            relations =
//                    {
//                            @JoinTypeRelation(parent = "question", children = {"answer", "comment"}),
//                            @JoinTypeRelation(parent = "answer", children = "vote")
//                    }
//    )
//    private JoinField<String> relation;
}
