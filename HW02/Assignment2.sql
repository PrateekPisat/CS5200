-- creating the databse
-- create database gad;

-- using the new database
use gad;

-- Q1. For each disease, how many publications report an association? Rank output by number of publications (most to least)
select phenotype,count(distinct(pubmed_id)) As 'Number of Publication'
from gad
group by phenotype
order by count(pubmed_id) desc;

--  Q2. For each disease, how many genes have been associated with that disease? Rank by the number of genes. Show only the top 10 results.
select phenotype, count(distinct(gene)) as 'Number of genes associated'
from gad
group by phenotype
order by count(gene) desc
limit 10;

-- Q3. What genes are linked to Asthma? Include any phenotypes that contain the string ‘asthma’ in your query. Rank the genes by the number of publications that report 
-- the linkage. Output the gene name, egid, and number of publications. Include only genes that have been linked to asthma-related phenotypes in 2 or more publications.
-- Create a VIEW called asthma_genes containing the output of these query.
 create view asthma_genes as
 select gene, egid, count(pubmed_id) as 'count'
 from gad
 where phenotype like '%asthma%'
 group by phenotype, gene
 having count > 1
 order by count(pubmed_id);

  drop view asthma_genes;

 select * from asthma_genes;
 

--  Q4. With the help of your VIEW from question 3, find all distinct gene-phenotype associations involving asthma genes. Sort your result by gene name, then phenotype
select asthma_genes.gene, gad.phenotype
from asthma_genes, gad
where asthma_genes.egid = gad.egid
group by asthma_genes.gene, gad.phenotype
order by asthma_genes.gene, gad.phenotype;


-- Q5.  Use your query from question 4 as a subquery in a new query that counts the number of overlapping asthma-related genes for each phenotype. Output the
-- 		phenotype and the number of overlapping genes, ranked in descending order by the size of the gene-set overlap. Output only the top 5 diseases / phenotypes. Exclude
-- 		asthma itself!
select phenotype as 'Diseases'
from
(
	select asthma_genes.gene, gad.phenotype
	from asthma_genes, gad
	where asthma_genes.egid = gad.egid
	group by asthma_genes.gene, gad.phenotype
	order by asthma_genes.gene, gad.phenotype
) 
as t1
group by phenotype
having phenotype not like '%asthma%'
order by count(t1.gene) desc
limit 5;


-- Q6.  For the asthma genes found in Q3 and the top two diseases found in Q4, what gene or genes do they all have in common?
select distinct(gad.gene) as 'Common_Genes'
from asthma_genes, (select phenotype as 'Diseases'
					from
					(
						select asthma_genes.gene, gad.phenotype
						from asthma_genes, gad
						where asthma_genes.egid = gad.egid
						group by asthma_genes.gene, gad.phenotype
						order by asthma_genes.gene, gad.phenotype
					) 
					as t1
					group by phenotype
					having phenotype not like '%asthma%'
					order by count(t1.gene) desc
					limit 2)
                    as t2, gad
where gad.gene = asthma_genes.gene and gad.phenotype = t2.Diseases
order by Common_Genes;


-- Extra Credit Quesion:
-- Identify all the gene-diseases association common between Japanese and all other populations so as to 
-- establish an association amongst the people, research techniques, etc.
-- Order by the number of associations(high to low), filter out the top ten associations.


create view common_diseases as 
select gene, phenotype, population
from gad;

select count(Common_Associations) as 'Total_Common_Associations', Population_2 as 'Population'
from
(
	select concat(gad.gene, gad.phenotype) as 'Common_Associations', gad.population as 'Population_1', common_diseases.population as 'Population_2'
	from common_diseases, gad
	where gad.phenotype = common_diseases.phenotype and gad.population = 'Japanese' and common_diseases.population <> '' and common_diseases.population <> 'Japanese' 
		  and gad.gene = common_diseases.gene
)
as t1
group by Population_1, Population_2
having count(Total_Common_Associations)>1
order by Total_Common_Associations desc
limit 10;

