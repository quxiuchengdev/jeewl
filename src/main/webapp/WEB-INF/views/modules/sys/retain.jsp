<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!-- 
<style type="text/css">
.sort {
	color: #0663A2;
	cursor: pointer;
} 
</style> -->
<script type="text/javascript">

jQuery(function($) {
	
	var columnNum = 7;
	var dialog = $("#columnCheckDiv");
	
	var options={
			path: "/",
			field: "id",
			expires: 30
		};
	dialog.find("input").keep("dictList",options);
	
	selectAction();

	$("#bootbox-confirm").click(function() {
		bootbox.dialog({
			  message: $("#columnCheckDiv").html(),
			  title: "定制列",
			  buttons: {
			    success: {
			      label: "确定!",
			      className: "btn-success",
			      callback: function() {
			    	  selectAction();
			      }
			    },
			    danger: {
			      label: "取消!",
			      className: "btn-danger",
			      callback: function() {
			       // Example.show("uh oh, look out!");
			      }
			    }
			  }
		});
	});
	function selectAction() {
		var checkArr = [];
		dialog.find("input[name=columnCheck]").each(function() {
			var id = $(this).attr("id");
			if($("#"+id).attr("checked")){
				//console.log("$(this).attr('columnIndex')", $(this).attr("columnIndex")); 
				checkArr.push($(this).attr("columnIndex"));
				
			}
		});
		console.log("check arr:", checkArr);
		for(var i=0;i<columnNum;i++){
			table.fnSetColumnVis(i,false,false);
		}
		for(var i=0;i<checkArr.length;i++){
			//console.log(checkArr[i]);
		 	table.fnSetColumnVis(checkArr[i],true,false);
		}
	}
});

//定制列选择input信息
function retainSelectInput(inputVar){
	var id = $(inputVar).attr("id");
	if($("#"+id).attr("checked")){
		$("#"+id).attr("checked",false);
	}else{
		$("#"+id).attr("checked",true);
	}
}

</script>
<div class="clearfix">
  <div class="pull-left tableTools-container">
    <div class="btn-group btn-overlap">
      <div class="btn-group"  data-rel='tooltip' data-placement="top" data-original-title="定制列">
        <button class="btn btn-white btn-info btn-bold" id="bootbox-confirm">
          <span>
            <i class="fa fa-search"></i>&nbsp;定制列
          </span>
        </button>
      </div>
    </div>
  </div>
</div>
<div style="display:none;" id="columnCheckDiv">
	<div class="control-group">
		<div class="checkbox">
			<label>
				<input onclick="retainSelectInput(this);" type="checkbox" name="columnCheck" id="columnCheck0" columnindex="0" class="ace ace-checkbox-2" checked="checked"/>
				<span class="lbl">全选</span>
			</label>
			<label>
				<input onclick="retainSelectInput(this);" type="checkbox" name="columnCheck"  columnindex="1" id="columnCheck1" class="ace ace-checkbox-2" />
				<span class="lbl">值</span>
			</label>
			<label>
				<input onclick="retainSelectInput(this);" type="checkbox" name="columnCheck"  columnindex="2" id="columnCheck2" class="ace ace-checkbox-2" />
				<span class="lbl">标签</span>
			</label>
			<label>
				<input onclick="retainSelectInput(this);" type="checkbox" name="columnCheck"  columnindex="3" id="columnCheck3" class="ace ace-checkbox-2" />
				<span class="lbl">类型</span>
			</label>
			<label>
				<input onclick="retainSelectInput(this);" type="checkbox" name="columnCheck"  columnindex="4" id="columnCheck4" class="ace ace-checkbox-2" />
				<span class="lbl">排序</span>
			</label>
			<label>
				<input onclick="retainSelectInput(this);" type="checkbox" name="columnCheck"  columnindex="5" id="columnCheck5" class="ace ace-checkbox-2" />
				<span class="lbl">描述</span>
			</label>
			<label>
				<input onclick="retainSelectInput(this);" type="checkbox" name="columnCheck"  columnindex="6" id="columnCheck6" class="ace ace-checkbox-2" />
				<span class="lbl">操作</span>
			</label>
		</div>
	</div>
</div>
