<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang='zh-CN'>

<head>
<title>PI6000 - 任务调度管理</title>
</head>
<body>
	<div >
            <div>
                <div>
                    <table style="width: 100%;">
                        <tr>
                            <td style="width: 100%;">
                                <a class="add_button">新建</a>
                                <a class="edit-button">编辑</a>
                                <a class="delete-button">删除</a>
                                <span  class="separator"></span>
                                <a class="runNow-button">立即执行</a>
                                <a class="start-button">启用</a>
                                <a class="stop-button">停用</a>
                            </td>
                        </tr>
                    </table>
                </div>

                <div class="ak-fit">
                    <div>
                        <div property="columns">
                            <div>任务名称</div>
                            <div>执行组件</div>
                            <div >任务状态</div>
                            <div >触发间隔/Cron表达式</div>
                            <div >触发次数</div>
                            <div >开始时间</div>
                        </div>
                    </div>

                    <div title="详细信息">

                    </div>
                    <div title="任务分组">

                    </div>
                    <div title="执行组件参数设置">

                    </div>
                </div>
            </div>

	</div>
</body>
</html>