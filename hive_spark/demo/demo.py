import pyspark
from pyspark.sql import SparkSession
spark = SparkSession.builder.master("local[1]") \
                    .appName('SparkByExamples.com') \
                    .enableHiveSupport() \
                    .getOrCreate()

spark.sql("select name from openbeer.breweries limit 10").show()