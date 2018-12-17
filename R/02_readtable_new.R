
#データ読み込み
{
appdata_201604<- fread('/home/fkondo/デスクトップ/kdMBappdata201604.tsv',encoding='UTF-8',stringsAsFactors=F,
                       colClasses=c("character", "character", "integer","character","character","character","character","character","character","character"))

appdata_201605<- fread('/home/fkondo/デスクトップ/kdMBappdata201605.tsv',encoding='UTF-8',stringsAsFactors=F,
                       colClasses=c("character", "character", "integer","character","character","character","character","character","character","character"))

appdata_201606<- fread('/home/fkondo/デスクトップ/kdMBappdata201606.tsv',encoding='UTF-8',stringsAsFactors=F,
                       colClasses=c("character", "character", "integer","character","character","character","character","character","character","character"))
}

#読込データ整形関数
readdata_use<-function(x){
  #データ名前変更
  x<- rename(x,
             monitor="モニターCue ※納品不可",
             time="日時(yyyy-mm-dd hh:mm:ss)",
             duration="接触時間（duration)",
             os="OS（Android or iOS）",
             contID="コンテンツID",
             packID="パッケージId",
             contname="コンテンツ名",
             appcat="アプリカテゴリ",
             appcomp="アプリ提供企業名",
             app="アプリ名")
  
  #データチェック
  str(x)
  
  #date読み込みフォーマット
  format <- "%Y-%m-%d %H:%M:%S"
  
  #データ型変更
  x$time<-parse_date_time2(x$time,format)
  str(x)
  return(x)

}

catcount <-function(x){ 
x %>% select(appcat) %>% 
          dplyr::group_by(appcat)%>% 
          dplyr::summarise(count=n())}

#appdata_201604 %>% dplyr::arrange(desc(monitor))

x %>% catamount <-appdata_201604 %>% 
          dplyr::group_by(appcat)%>% 
          dplyr::summarise(count=n())%>%
          dplyr::arrange(desc(count))     
}
#catamount1 <-appdata_201605 %>% 
         # dplyr::group_by(appcat)%>% 
          #dplyr::summarise(count=n())%>%
          #dplyr::arrange(desc(count)) 
catamount2 <-appdata_201606 %>% 
          dplyr::group_by(appcat)%>% 
          dplyr::summarise(count=n())%>%
          dplyr::arrange(desc(count)) 
##appcat <- dplyr::filter(app cat, appcat="")
appdata_201604<-dplyr::filter(appdata_201604,appcat=="ツール類",appcat=="ソーシャルネットワーキング",appcat=="ゲーム",appcat=="ニュース")

appdata_201604<-readdata_use(appdata_201604)
appdata_201605<-readdata_use(appdata_201605)
appdata_201606<-readdata_use(appdata_201606)

#カテゴリ選別作業

appdata_201604 <-dplyr::filter(appdata_201604,appcat==c("ツール類","ソーシャルネットワーキング","ゲーム","ニュース"))
appdata_201605 <-dplyr::filter(appdata_201605,appcat==c("ツール類","ソーシャルネットワーキング","ゲーム","ニュース"))
appdata_201606 <-dplyr::filter(appdata_201606,appcat==c("ツール類","ソーシャルネットワーキング","ゲーム","ニュース"))
#%in%
#ニュースを外す可能性も
appdata_201604 <-dplyr::filter(appdata_201604,appcat==c("ツール類","ソーシャルネットワーキング","ゲーム"))
appdata_201605 <-dplyr::filter(appdata_201605,appcat==c("ツール類","ソーシャルネットワーキング","ゲーム"))
appdata_201606 <-dplyr::filter(appdata_201606,appcat==c("ツール類","ソーシャルネットワーキング","ゲーム"))

#カテゴリー選択
appdata_201604 <-dplyr::filter(appdata_201604,appcat %in% c("ツール類","ソーシャルネットワーキング"))
appdata_201605 <-dplyr::filter(appdata_201605,appcat %in% c("ツール類","ソーシャルネットワーキング"))
appdata_201606 <-dplyr::filter(appdata_201606,appcat %in% c("ツール類","ソーシャルネットワーキング"))
#モニタ別回数全体(カテゴリーごと)(問題あり？)

times<-function(x){
  x %>% select(monitor,time,duration,appcat) %>% 
  dplyr::group_by(monitor,appcat) %>% 
  dplyr::summarise(n=n()) %>% 
  #dplyr::arrange(desc(n))
  dplyr::arrange(desc(monitor))

}

#appdata_201604_times<-times(filtercate2016_04)
#appdata_201605_times<-times(filtercate2016_05)
#appdata_201606_times<-times(filtercate2016_06)
appdata_201604_times<-times(appdata_201604)
appdata_201605_times<-times(appdata_201605)
appdata_201606_times<-times(appdata_201606)

#クリーニング作業
#月300回未満起動削除
#アプリカテゴリ別に削除
#appdata_201604_times<-dplyr::filter(appdata_201604_times,n>=30),appcat==c("ツール類","ソー#シャルネットワーキング","ゲーム","ニュース"))
#appdata_201605_times<-dplyr::filter(appdata_201605_times,n>=300)
#appdata_201606_times<-dplyr::filter(appdata_201606_times,n>=300)
#30回ももしくは45回
appdata_201604_times<-dplyr::filter(appdata_201604_times,n>=45)
appdata_201605_times<-dplyr::filter(appdata_201605_times,n>=45)
appdata_201606_times<-dplyr::filter(appdata_201606_times,n>=45)

#クリーニング後データ
#appdata_201604<-inner_join(filtercate2016_04,appdata_201604_times,by = "monitor")
#appdata_201605<-inner_join(filtercate2016_05,appdata_201605_times,by = "monitor")
#appdata_201606<-inner_join(filtercate2016_06,appdata_201606_times,by = "monitor")
#多分ここがおかしいjoint方法に問題あり
appdata_201604<-inner_join(appdata_201604,appdata_201604_times,by = "monitor")
appdata_201605<-inner_join(appdata_201605,appdata_201604_times,by = "monitor")
appdata_201606<-inner_join(appdata_201606,appdata_201604_times,by = "monitor")

appdata_201604<-inner_join(appdata_201604,appdata_201604_times,by = c("monitor","appcat"))


#重複を取り除く
#xとyが違う列を削除<-データの重複を削る

appdata_201604 <-dplyr::filter(appdata_201604,appcat.x==appcat.y)
appdata_201605 <-dplyr::filter(appdata_201605,appcat.x==appcat.y)
appdata_201606 <-dplyr::filter(appdata_201606,appcat.x==appcat.y)



appdata_201605  %>% dplyr::arrange(desc(monitor))


#3か月データ作成
appdata_201604_06<-rbind(appdata_201604,appdata_201605,appdata_201606)
monitor_201604_06<-inner_join(appdata_201604_times,appdata_201605_times,by="monitor")
##ここでフィルター処理が必要
monitor_201604_06<-inner_join(monitor_201604_06,appdata_201606_times,by="monitor")
##ここでフィルター処理が必要
monitor_201604_06<-dplyr::filter(monitor_201604_06,appcat.x==appcat.y)
monitor_201604_06<-dplyr::filter(monitor_201604_06,appcat.x==appcat)
monitor_201604_06<-monitor_201604_06 %>% dplyr::select(monitor)
appdata_201604_06<-inner_join(appdata_201604_06,monitor_201604_06,by="monitor")


##時間・個人・カテゴリーごと
##エラーappcatなし
monitor_time<-function(x){
  x %>% dplyr::select(monitor,time,duration,appcat.x) %>%
  dplyr::mutate(hour=hour(time),year=year(time),month=month(time),day=day(time)) %>%
  dplyr::group_by(monitor,year,month,day,hour,appcat.x) %>%
  dplyr::summarise(n=n())
}
monitor_time1<-function(x){
  x %>% dplyr::select(monitor,time,duration,appcat.x,appcat.y) %>%
  dplyr::mutate(hour=hour(time),year=year(time),month=month(time),day=day(time)) %>%
  dplyr::group_by(monitor,year,month,day,hour,appcat.x) %>%
  dplyr::summarise(n=n())
}

appdata_201604_06_time_monitor<-monitor_time(appdata_201604_06)

appdata_201604_06_time_monitor1<-monitor_time1(appdata_201604_06)


##全体1時間ごと使用回数
time_data<-function(df){
  dplyr::select(df,monitor,time,duration,appcat.x) %>%
    dplyr::mutate(hour=hour(time),year=year(time),month=month(time),day=day(time)) %>%
    dplyr::group_by(year,month,day,hour,appcat.x) %>%
    dplyr::summarise(n=n())
}

appdata_201604_06_time<-time_data(appdata_201604_06)
#ts.plot(appdata_201604_06_time)

##人ごとの回数
times1<-function(x){
  x %>% select(monitor,time,duration,appcat.x) %>% 
  dplyr::group_by(monitor,appcat.x) %>% 
  dplyr::summarise(n=n()) %>% 
  #dplyr::arrange(desc(n))
  dplyr::arrange(desc(monitor))
  

}
category <- function(x){
  x %>% select(monitor,appcat.x) %>%
  dplyr::group_by(monitor) %>%
  dplyr::summarise(n=n()) 
}

#全てのカテゴリーを持つIDのみの抽出
appdata_201604_06_acccount <- category(appdata_201604_06_times)
appdata_201604_06_acccount <- dplyr::filter(appdata_201604_06_acccount,n==3)


appdata_201604_06_times<-times1(appdata_201604_06)
appdata_201604_06_times<-inner_join(appdata_201604_06_times,appdata_201604_06_acccount,by="monitor")
#個人別アプリ起動グラフ
#{
 # g<- ggplot(appdata_201604_06_times,aes(x=log(appdata_201604_06_times$n)))
  #g<- g + geom_histogram()
  #plot(g)
  
  #g<- ggplot(appdata_201604_06_times,aes(x=appdata_201604_06_times$n))
  #g<- g + geom_histogram()
  #plot(g)
#}



y7 <-dplyr::filter(y7,monitor==c("50001718601","50000042006"))

#不要削除
rm(appdata_201604,appdata_201604_times,appdata_201605,
     appdata_201605_times,appdata_201606,appdata_201606_times,monitor_201604_06)

