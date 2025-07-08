- [  
  ](#section)
- [](#section-1)
- [Table of Contents](#table-of-contents)
- [ ](#section-2)
- [Introduction](#introduction)
  - [**1.1 Structure of this document**](#structure-of-this-document)
  - [**1.2 Supported conversions**](#supported-conversions)
  - [**1.3 CSV and FLR limitations**](#csv-and-flr-limitations)
  - [**1.4 Excel limitations**](#excel-limitations)
  - [**1.5 Limitations when converting Message Group SDMX-ML
    messages**](#limitations-when-converting-message-group-sdmx-ml-messages)
- [Using the Converter Web Service](#using-the-converter-web-service)
  - [**SOAP Web services**](#soap-web-services)
  - [**Web Service Descriptor for Converter
    (WSDL)**](#web-service-descriptor-for-converter-wsdl)
  - [**Using the “ConvertData” method of the Converter web
    service**](#using-the-convertdata-method-of-the-converter-web-service)
  - [](#section-3)
  - [**Using the “GetWsVersion” method of the Converter web
    service**](#using-the-getwsversion-method-of-the-converter-web-service)
  - [**A sample C# web service client for
    “ConvertData”**](#a-sample-c-web-service-client-for-convertdata)
  - [**A sample C# web service client for
    “ValidateData”**](#a-sample-c-web-service-client-for-validatedata)
  - [**Using the “ValidateData” method of the Struval web
    service**](#using-the-validatedata-method-of-the-struval-web-service)
    - [ **“ValidateData” method
      parameters**](#validatedata-method-parameters)
    - [**File type checks**](#file-type-checks)
    - [Checks for specific inputs](#checks-for-specific-inputs)
    - [**The** **Asynchronous “ValidateData” method
      result**](#the-asynchronous-validatedata-method-result)
    - [**A sample request to the asynchronous “ValidateData” of Struval
      Web Service using SOAPUI
      tool**](#a-sample-request-to-the-asynchronous-validatedata-of-struval-web-service-using-soapui-tool)
    - [**A sample request to “ValidateData” using SOAPUI tool with MTOM
      enabled**](#a-sample-request-to-validatedata-using-soapui-tool-with-mtom-enabled)
  - [**Using the “CustomValidateData” method of the Struval web
    service**](#using-the-customvalidatedata-method-of-the-struval-web-service)
    - [**“CustomValidateData” method
      parameters**](#customvalidatedata-method-parameters)
    - [**“CustomValidateData” method
      result**](#customvalidatedata-method-result)
  - [**Using the “ExplainError” method of the Struval web
    service**](#using-the-explainerror-method-of-the-struval-web-service)
    - [**“ExplainError” method
      parameters**](#explainerror-method-parameters)
  - [**Using the “GetVersion” method of the Struval web
    service**](#using-the-getversion-method-of-the-struval-web-service)
    - [**“GetVersion” method
      parameters**](#getversion-method-parameters)
    - [**The available options for the “version” output parameter**
      ](#the-available-options-for-the-version-output-parameter)
    - [**The available options for the “format” output
      parameter**](#the-available-options-for-the-format-output-parameter)
    - [**Unsupported formats**](#unsupported-formats)
  - [**Using the “GetWsVersion” method of the Struval web
    service**](#using-the-getwsversion-method-of-the-struval-web-service)
  - [**Using the “GetMetadataMetrics” method of the Metadata metrics web
    service**](#using-the-getmetadatametrics-method-of-the-metadata-metrics-web-service)
    - [**“GetMetadataMetrics” method
      parameters**](#getmetadatametrics-method-parameters)
    - [**“GetMetadataMetrics” method
      result**](#getmetadatametrics-method-result)
  - [**Using the “transform” method of the Converter Transformation
    service**](#using-the-transform-method-of-the-converter-transformation-service)
    - [**A “transform” method request**](#a-transform-method-request)

<table>
<colgroup>
<col style="width: 18%" />
<col style="width: 81%" />
</colgroup>
<tbody>
<tr>
<td><img src="media/image1.wmf"
style="width:1.1in;height:0.73333in" /></td>
<td><p>EUROPEAN COMMISSION</p>
<p>EUROSTAT</p>
<p>Directorate B: Statistical methodologies and tools</p>
<p><strong>Unit B-3: Statistical information
technologies</strong></p></td>
</tr>
</tbody>
</table>

<span id="_Toc156214415" class="anchor"></span>SDMX Converter Web
Service User Manual

Version 7.3

May 2017

<span id="_Toc156214416" class="anchor"></span>Document Change Record

<table>
<colgroup>
<col style="width: 15%" />
<col style="width: 15%" />
<col style="width: 68%" />
</colgroup>
<tbody>
<tr>
<td style="text-align: left;">Issue/Revision</td>
<td>Date</td>
<td style="text-align: left;">Change</td>
</tr>
<tr>
<td style="text-align: left;">0.1</td>
<td style="text-align: center;">13.03.2017</td>
<td style="text-align: left;">Updated Converter Web Services in
accordance with SDMXCONV-383</td>
</tr>
<tr>
<td style="text-align: left;">1.0</td>
<td style="text-align: center;">15.03.2017</td>
<td style="text-align: left;">Document reviewed and ready for
delivery.</td>
</tr>
<tr>
<td style="text-align: left;">1.1</td>
<td style="text-align: center;">10.05.2017</td>
<td style="text-align: left;">“GetVersion” method added to the
webservice</td>
</tr>
<tr>
<td style="text-align: left;">1.2</td>
<td style="text-align: center;">17.05.2017</td>
<td style="text-align: left;">Changes for SDMXCONV-416</td>
</tr>
<tr>
<td style="text-align: left;">1.3</td>
<td style="text-align: center;">22.09.2017</td>
<td style="text-align: left;">Changes of ValidateData parameters
(SDMXCONV-522)</td>
</tr>
<tr>
<td style="text-align: left;">1.4</td>
<td style="text-align: center;">06.10.2017</td>
<td style="text-align: left;">Changes for SDMXCONV-534, HeaderRow param
in WS needs clarifications.</td>
</tr>
<tr>
<td style="text-align: left;">1.5</td>
<td style="text-align: center;">10.10.2017</td>
<td style="text-align: left;">Changes for SDMXCONV-473, HeaderWriting
tag</td>
</tr>
<tr>
<td style="text-align: left;">1.6</td>
<td style="text-align: center;">09.11.2017</td>
<td style="text-align: left;">Changes for SDMXCONV-516/SDMXCONV
524/SDMXSOURCE-9, SDMXCONV-536, SDMXCONV-538, SDMXCONV-540</td>
</tr>
<tr>
<td style="text-align: left;">1.7</td>
<td style="text-align: center;">28/11/2017</td>
<td style="text-align: left;"><p>SDMXCONV-498, Header required by
converter for EXCEL to CSV</p>
<p>SDMXCONV-455, csv input cannot have more columns than dsd
components</p></td>
</tr>
<tr>
<td style="text-align: left;">1.8</td>
<td style="text-align: center;">08/12/2017</td>
<td style="text-align: left;">SDMXCONV-575 usage of quotes for CSV
files</td>
</tr>
<tr>
<td style="text-align: left;">1.9</td>
<td style="text-align: center;">15/12/2017</td>
<td style="text-align: left;"><p>SDMXCONV-563, Difference at validation
between v6.5.2 and 6.10.1 with no DSD id,agency and version</p>
<p>SDMXCONV-591, align the behaviour for the different input output
formats;</p></td>
</tr>
<tr>
<td style="text-align: left;">2.0</td>
<td style="text-align: center;">28/02/2018</td>
<td style="text-align: left;">SDMXCONV-645 Access registries over SSL
(HTTPS)</td>
</tr>
<tr>
<td style="text-align: left;">2.1</td>
<td style="text-align: center;">16/04/2018</td>
<td style="text-align: left;">SDMXCONV-636 – Enhanced excel parameter
support</td>
</tr>
<tr>
<td style="text-align: left;">2.2</td>
<td style="text-align: center;">24/04/2018</td>
<td style="text-align: left;">SDMXCONV-668 – Convert from CSV to
SDMX-ML: NO_HEADER not recognised</td>
</tr>
<tr>
<td style="text-align: left;">2.3</td>
<td style="text-align: center;">11/06/2018</td>
<td style="text-align: left;">SDMXCONV-638 – FLR format to be
supported</td>
</tr>
<tr>
<td style="text-align: left;">2.4</td>
<td style="text-align: center;">11/07/2018</td>
<td style="text-align: left;"><p>SDMXCONV-709 - implementation in type
in the namespace</p>
<p>SDMXCONV-723 - Wsdl changes for SDMXCONV-639 - Config file Phase
II</p></td>
</tr>
<tr>
<td style="text-align: left;">2.5</td>
<td style="text-align: center;">27/08/2018</td>
<td style="text-align: left;"><p>SDMXCONV-722 - WS Extend autodetection
of input file to other formats</p>
<p>SDMXCONV-698 - Error Report: additional fields needed</p></td>
</tr>
<tr>
<td style="text-align: left;">2.6</td>
<td style="text-align: center;">02/10/2018</td>
<td style="text-align: left;">SDMXCONV-700 - validation of FLR input
files</td>
</tr>
<tr>
<td style="text-align: left;">2.7</td>
<td style="text-align: center;">24/10/2018</td>
<td style="text-align: left;">SDMXCONV-746 – External excel parameter
sheet for Energy templates.</td>
</tr>
<tr>
<td style="text-align: left;">2.8</td>
<td style="text-align: center;">18/12/2018</td>
<td style="text-align: left;">SDMXCONV-749 – Implementation of missing
version in the SDMX message</td>
</tr>
<tr>
<td style="text-align: left;">2.9</td>
<td style="text-align: center;">16/01/2019</td>
<td style="text-align: left;">SDMXCONV-811 - Sementic error with excel
file</td>
</tr>
<tr>
<td style="text-align: left;">3.0</td>
<td style="text-align: center;">21/03/2019</td>
<td style="text-align: left;"><p>SDMXCONV-759 – GetWsVersion in
Converter/Struval WS</p>
<p>SDMXCONV-854 - Conversion CSV to SDMX_CSV: missing delimiter
parameter for OUTPUT file</p>
<p>SDMXCONV-740 - EXCEL input file based validation</p></td>
</tr>
<tr>
<td style="text-align: left;">3.1</td>
<td style="text-align: center;">03/04/2019</td>
<td style="text-align: left;">SDMXCONV-876 - Conversion from FLR to CSV
not supported</td>
</tr>
<tr>
<td style="text-align: left;">3.2</td>
<td style="text-align: center;">25/04/2019</td>
<td style="text-align: left;"><p>SDMXCONV-795 - Update of STRUVAL
documentation</p>
<p>SDMXCONV-875 - Difference between struval error codes and the
documentation</p></td>
</tr>
<tr>
<td style="text-align: left;"></td>
<td style="text-align: center;">06/08/2019</td>
<td style="text-align: left;">SDMXCONV-951 - Parameter ErrorIfEmpty</td>
</tr>
<tr>
<td style="text-align: left;">3.3</td>
<td style="text-align: center;">21/06/2019</td>
<td style="text-align: left;"><p>SDMXCONV-796 - LFs and multiple
measures</p>
<p>SDMXCONV-797 - Support mapping of a SDMX v2.1 measure dimension’s
concepts</p>
<p>SDMXCONV-799 - Modify the GUI &amp; WebApp to support SDMX v2.1
measure dimension concept mappings</p>
<p>SDMXCONV-800 - Transcoding support for SDMX v2.1 measure dimension
concepts</p>
<p>SDMXCONV-801 - Single Level CSV Writer support for SDMX v2.1 measure
dim. concepts as columns</p>
<p>SDMXCONV-916 - Add support in SdmxSource for explicit measures in
structure reference. Delete this link</p>
<p>SDMXCONV-798 - FLR Reader support for SDMX 2.1 measure dim. concepts
as columns</p>
<p>SDMXCONV-922 - Missing documentation for "SkipIncompleteKeys"</p>
<p>SDMXCONV-927 - Excel should use actual value by default for
numbers</p></td>
</tr>
<tr>
<td style="text-align: left;">3.4</td>
<td style="text-align: center;">23/07/2019</td>
<td style="text-align: left;">SDMXCONV-761 – Error report improvement :
display the line number that raises an error</td>
</tr>
<tr>
<td style="text-align: left;">3.5</td>
<td style="text-align: center;">07/08/2019</td>
<td style="text-align: left;">SDMXCONV-867 - SDMX CSV internal
format</td>
</tr>
<tr>
<td style="text-align: left;">3.6</td>
<td style="text-align: center;">20/09/2019</td>
<td style="text-align: left;">SDMXCONV-980 - Sheet with name "Transport"
recognized as transcoding sheet</td>
</tr>
<tr>
<td style="text-align: left;">3.7</td>
<td style="text-align: center;">01/10/2019</td>
<td style="text-align: left;">SDMXCONV-964 - Documentation improvement :
MTOM explanation</td>
</tr>
<tr>
<td style="text-align: left;">3.8</td>
<td style="text-align: center;">18/10/2019</td>
<td style="text-align: left;">SDMXCONV-999 - Converter WS cannot respond
SOAP Fault in WebLogic anymore</td>
</tr>
<tr>
<td style="text-align: left;">3.9</td>
<td style="text-align: center;">10/12/2019</td>
<td style="text-align: left;">SDMXCONV-1025 - Conform CSV Writers with
RFC4180</td>
</tr>
<tr>
<td style="text-align: left;">4.0</td>
<td style="text-align: center;">10/01/2020</td>
<td style="text-align: left;">SDMXCONV-908 - STRUVAL/CONVERTER Metadata
service</td>
</tr>
<tr>
<td style="text-align: left;">4.1</td>
<td style="text-align: center;">21/01/2020</td>
<td style="text-align: left;">SDMXCONV-914 - STRUVAL output reports to
use MSD</td>
</tr>
<tr>
<td style="text-align: left;">4.1</td>
<td style="text-align: center;">21/01/2020</td>
<td style="text-align: left;">SDMXCONV-1019 - STRUVAL should be able to
output the old validation report and the MSD based one</td>
</tr>
<tr>
<td style="text-align: left;">4.2</td>
<td style="text-align: center;">26/02/2020</td>
<td style="text-align: left;"><p>SDMXCONV-775 – Converter should be able
to output FLR files</p>
<p>SDMXCONV-1036 – Conversion from SDMX-CSV format to FLR</p></td>
</tr>
<tr>
<td style="text-align: left;">4.3</td>
<td style="text-align: center;">06/04/2020</td>
<td style="text-align: left;"><p>SDMXCONV-1047 - Download mapping file
for FLR output auto mapping</p>
<p>SDMXCONV-1052 - STRUVAL reports for non UTF-8 encoding files</p></td>
</tr>
<tr>
<td style="text-align: left;">4.4</td>
<td style="text-align: center;">22/05/2020</td>
<td style="text-align: left;"><p>SDMXCONV-1060 - MSD report, include it
as an attachment with the old report in the main soap body</p>
<p>SDMXCONV-907 - Possibility to use formulas in external Excel
parameter sheet</p>
<p>SDMXCONV-1031 - Energy Phase 4 (MOS%) UAT</p></td>
</tr>
<tr>
<td style="text-align: left;">4.5</td>
<td style="text-align: center;">20/07/2020</td>
<td style="text-align: left;">SDMXCONV-1095 - Converter
improvements</td>
</tr>
<tr>
<td style="text-align: left;">4.6</td>
<td style="text-align: center;">23/07/2020</td>
<td style="text-align: left;"><p>SDMXCONV-1095 - Converter
improvements</p>
<p>SDMXCONV-1085 - SDMX Converter - TRASE is missing Output HeaderRow
parameter</p></td>
</tr>
<tr>
<td style="text-align: left;">4.7</td>
<td style="text-align: center;">15/12/2020</td>
<td style="text-align: left;"><p>SDMXCONV-1134 - Issue with SDMX-CSV
validation – No error raised if column does not correspond to a concept
in the DSD</p>
<p>SDMXCONV-1135 - Issue with CSV validation – not possible to
simultaneously impose column order and header names</p>
<p>SDMXCONV-1155 - Timeout uploading files in the webapp</p>
<p>SDMXCONV-1123 - sample/doc for struval/converter WS</p></td>
</tr>
<tr>
<td style="text-align: left;">4.8</td>
<td style="text-align: center;">01/02/2021</td>
<td style="text-align: left;">SDMXCONV-1135 - Issue with CSV validation
– not possible to simultaneously impose column order and header
names</td>
</tr>
<tr>
<td style="text-align: left;">4.9</td>
<td style="text-align: center;">26/02/2021</td>
<td style="text-align: left;"><p>SDMXCONV-1168 - sample/doc for
converter WS client in .NET</p>
<p>SDMXCONV-1186 - ErrorIfEmpty to be moved from instance to WS call
parameter</p></td>
</tr>
<tr>
<td style="text-align: left;">5.0</td>
<td style="text-align: center;">28/04/2021</td>
<td style="text-align: left;">SDMXCONV-824 - Harmonised Transformation
interface</td>
</tr>
<tr>
<td style="text-align: left;">5.1</td>
<td style="text-align: center;">19/05/2021</td>
<td style="text-align: left;">SDMXCONV-1195 - MRR: value tag with wrong
information</td>
</tr>
<tr>
<td style="text-align: left;">5.2</td>
<td style="text-align: center;">30/06/2021</td>
<td style="text-align: left;">SDMXCONV-1205 - File without TIME_PERIOD
or OBS_VALUE considered valid in Struval</td>
</tr>
<tr>
<td style="text-align: left;">5.3</td>
<td style="text-align: center;">03/06/2021</td>
<td style="text-align: left;">SDMXCONV-1194 - Possibility to reject a
CSV file with an empty line</td>
</tr>
<tr>
<td style="text-align: left;">5.4</td>
<td style="text-align: center;">01/10/2021</td>
<td style="text-align: left;">SDMXCONV-1187 - Async calls in
STRUVAL-implementation</td>
</tr>
<tr>
<td style="text-align: left;">5.5</td>
<td style="text-align: center;">20/10/2021</td>
<td style="text-align: left;">SDMXCONV-1239 - Excel formula errors not
reported by Struval validation</td>
</tr>
<tr>
<td style="text-align: left;">5.6</td>
<td style="text-align: center;">02/11/2021</td>
<td style="text-align: left;">SDMXCONV-1187 - Async calls in
STRUVAL-implementation</td>
</tr>
<tr>
<td style="text-align: left;">5.7</td>
<td style="text-align: center;">21/03/2022</td>
<td style="text-align: left;">SDMXCONV-1213 - HTI status</td>
</tr>
<tr>
<td style="text-align: left;">5.8</td>
<td style="text-align: center;">14/06/2022</td>
<td style="text-align: left;">SDMXCONV-1316 – update documentation of
parameter ErrorIfEmpty in the manual of the converter</td>
</tr>
<tr>
<td style="text-align: left;">5.9</td>
<td style="text-align: center;">25/07/2021</td>
<td style="text-align: left;">SDMXCONV-1286 - Include a PreProcessing
sheet</td>
</tr>
<tr>
<td style="text-align: left;">6.0</td>
<td style="text-align: center;">08/09/2022</td>
<td style="text-align: left;"><p>SDMXCONV-1215 - generate HTI config
file from webapp</p>
<p>SDMXCONV-1285 - SkipColumns parameters</p>
<p>SDMXCONV-1240 - SDMX-CSV support reading &amp; writing ID &amp;
Labels</p></td>
</tr>
<tr>
<td style="text-align: left;">6.1</td>
<td style="text-align: center;">10/10/2022</td>
<td style="text-align: left;">SDMXCONV-1361 - String validation too
strict in Struval</td>
</tr>
<tr>
<td style="text-align: left;">6.2</td>
<td style="text-align: center;">8/11/2022</td>
<td style="text-align: left;">SDMXCONV-1374 - Implement SDMX-CSV 2.0.0
data writer basic support<br />
SDMXCONV-1376 - Implement SDMX-CSV 2.0.0 data writer multi lingual
support</td>
</tr>
<tr>
<td style="text-align: left;">6.3</td>
<td style="text-align: center;">09/05/2023</td>
<td style="text-align: left;"><p>SDMXCONV-1277 - STRUVAL support
validating SDMX 3.0.0 Structure Specific Data</p>
<p>SDMXCONV-1363 - reduce report size by grouping/removing duplicates
errors.</p>
<p>SDMXCONV-1292 - SDMX- Converter tools-add SDMX header elements into
SDMX_CSV</p>
<p>SDMXCONV-1351 - Support for SDMX 3.0.0 features in non SDMX standard
formats</p></td>
</tr>
<tr>
<td style="text-align: left;">6.4</td>
<td style="text-align: center;">24/05/2023</td>
<td style="text-align: left;">SDMXCONV-1434 - difference in wsdl and
documentation for struval response</td>
</tr>
<tr>
<td style="text-align: left;">6.5</td>
<td style="text-align: center;">18/06/2023</td>
<td style="text-align: left;">SDMXCONV-1481 - missing StatusResponse in
Struval for errors</td>
</tr>
<tr>
<td style="text-align: left;">6.6</td>
<td style="text-align: center;">22/12/2023</td>
<td style="text-align: left;">SDMXCONV-1514 - Support for SDMX 3.0.0
features with Excel input</td>
</tr>
<tr>
<td style="text-align: left;">6.7</td>
<td style="text-align: center;">26/01/2024</td>
<td style="text-align: left;"><p>SDMXCONV-1537 - missed observations are
presented as null values in the converted file</p>
<p>SDMXCONV-1540 - Add an example to the documentation for EXCEL
parameter file</p></td>
</tr>
<tr>
<td style="text-align: left;">6.8</td>
<td style="text-align: center;">20/02/2024</td>
<td style="text-align: left;">SDMXCONV-1516 - Improvement of registry
integration<br />
SDMXCONV-1515 - Support for SDMX 3.0.0 features in FLR</td>
</tr>
<tr>
<td style="text-align: left;">6.9</td>
<td style="text-align: center;">30/04/2024</td>
<td style="text-align: left;">SDMXCONV-1558 - Support for SDMX 3.0.0
features in FLR writer</td>
</tr>
<tr>
<td style="text-align: left;">7.0</td>
<td style="text-align: center;">13/06/2024</td>
<td style="text-align: left;">SDMXCONV-1568 - async call implementation
for convesion</td>
</tr>
<tr>
<td style="text-align: left;">7.1</td>
<td style="text-align: center;">09/08/2024</td>
<td style="text-align: left;">SDMXCONV-1545 - Target Java 11</td>
</tr>
<tr>
<td style="text-align: left;">7.2</td>
<td style="text-align: center;">03/10/2024</td>
<td style="text-align: left;">SDMXCONV-1321 - ErrorIfEmpty parameter for
all input data types in STRUVAL</td>
</tr>
<tr>
<td style="text-align: left;">7.3</td>
<td style="text-align: center;">20/03/2025</td>
<td style="text-align: left;">SDMXCONV-1528 - Apply "Allow additional
column" parameter for the files with the mapping</td>
</tr>
</tbody>
</table>

#  

# 

# Table of Contents

[SDMX Converter Web Service User Manual
[1](#_Toc156214415)](#_Toc156214415)

[Document Change Record [2](#_Toc156214416)](#_Toc156214416)

[1 Introduction [9](#introduction)](#introduction)

[**1.1 Structure of this document**
[9](#structure-of-this-document)](#structure-of-this-document)

[**1.2 Supported conversions**
[9](#supported-conversions)](#supported-conversions)

[**1.3 CSV and FLR limitations**
[11](#csv-and-flr-limitations)](#csv-and-flr-limitations)

[**1.4 Excel limitations** [12](#excel-limitations)](#excel-limitations)

[**1.5 Limitations when converting Message Group SDMX-ML messages**
[12](#limitations-when-converting-message-group-sdmx-ml-messages)](#limitations-when-converting-message-group-sdmx-ml-messages)

[2 Using the Converter Web Service
[13](#using-the-converter-web-service)](#using-the-converter-web-service)

[**SOAP Web services** [13](#soap-web-services)](#soap-web-services)

[**Web Service Descriptor for Converter (WSDL)**
[13](#web-service-descriptor-for-converter-wsdl)](#web-service-descriptor-for-converter-wsdl)

[**Using the “ConvertData” method of the Converter web service**
[15](#using-the-convertdata-method-of-the-converter-web-service)](#using-the-convertdata-method-of-the-converter-web-service)

[**Using the “GetWsVersion” method of the Converter web service**
[28](#using-the-getwsversion-method-of-the-converter-web-service)](#using-the-getwsversion-method-of-the-converter-web-service)

[**A sample C# web service client for “ConvertData”**
[29](#a-sample-c-web-service-client-for-convertdata)](#a-sample-c-web-service-client-for-convertdata)

[**A sample C# web service client for “ValidateData”**
[31](#a-sample-c-web-service-client-for-validatedata)](#a-sample-c-web-service-client-for-validatedata)

[**Using the “ValidateData” method of the Struval web service**
[32](#using-the-validatedata-method-of-the-struval-web-service)](#using-the-validatedata-method-of-the-struval-web-service)

[**“ValidateData” method parameters**
[33](#validatedata-method-parameters)](#validatedata-method-parameters)

[**File type checks** [37](#file-type-checks)](#file-type-checks)

[Checks for specific inputs
[38](#checks-for-specific-inputs)](#checks-for-specific-inputs)

[**The Asynchronous “ValidateData” method result**
[39](#the-asynchronous-validatedata-method-result)](#the-asynchronous-validatedata-method-result)

[**A sample request to the asynchronous “ValidateData” of Struval Web
Service using SOAPUI tool**
[42](#a-sample-request-to-the-asynchronous-validatedata-of-struval-web-service-using-soapui-tool)](#a-sample-request-to-the-asynchronous-validatedata-of-struval-web-service-using-soapui-tool)

[**A sample request to “ValidateData” using SOAPUI tool with MTOM
enabled**
[48](#a-sample-request-to-validatedata-using-soapui-tool-with-mtom-enabled)](#a-sample-request-to-validatedata-using-soapui-tool-with-mtom-enabled)

[**Using the “CustomValidateData” method of the Struval web service**
[50](#using-the-customvalidatedata-method-of-the-struval-web-service)](#using-the-customvalidatedata-method-of-the-struval-web-service)

[**“CustomValidateData” method parameters**
[51](#customvalidatedata-method-parameters)](#customvalidatedata-method-parameters)

[**“CustomValidateData” method result**
[52](#customvalidatedata-method-result)](#customvalidatedata-method-result)

[**Using the “ExplainError” method of the Struval web service**
[52](#using-the-explainerror-method-of-the-struval-web-service)](#using-the-explainerror-method-of-the-struval-web-service)

[**“ExplainError” method parameters**
[52](#explainerror-method-parameters)](#explainerror-method-parameters)

[**Using the “GetVersion” method of the Struval web service**
[54](#using-the-getversion-method-of-the-struval-web-service)](#using-the-getversion-method-of-the-struval-web-service)

[**“GetVersion” method parameters**
[54](#getversion-method-parameters)](#getversion-method-parameters)

[**The available options for the “version” output parameter**
[55](#the-available-options-for-the-version-output-parameter)](#the-available-options-for-the-version-output-parameter)

[**The available options for the “format” output parameter**
[56](#the-available-options-for-the-format-output-parameter)](#the-available-options-for-the-format-output-parameter)

[**Unsupported formats**
[56](#unsupported-formats)](#unsupported-formats)

[**Using the “GetWsVersion” method of the Struval web service**
[57](#using-the-getwsversion-method-of-the-struval-web-service)](#using-the-getwsversion-method-of-the-struval-web-service)

[**Using the “GetMetadataMetrics” method of the Metadata metrics web
service**
[58](#using-the-getmetadatametrics-method-of-the-metadata-metrics-web-service)](#using-the-getmetadatametrics-method-of-the-metadata-metrics-web-service)

[**“GetMetadataMetrics” method parameters**
[58](#getmetadatametrics-method-parameters)](#getmetadatametrics-method-parameters)

[**“GetMetadataMetrics” method result**
[59](#getmetadatametrics-method-result)](#getmetadatametrics-method-result)

[**Using the “transform” method of the Converter Transformation
service**
[59](#using-the-transform-method-of-the-converter-transformation-service)](#using-the-transform-method-of-the-converter-transformation-service)

[**A “transform” method request**
[59](#a-transform-method-request)](#a-transform-method-request)

[Annex A: Structure of a multilevel CSV/FLR
[64](#_Toc81513626)](#_Toc81513626)

[**Multilevel files**
[64](#__RefHeading__440_1278425962)](#__RefHeading__440_1278425962)

[**Sample multilevel CSV file**
[65](#__RefHeading__1071_1307807964)](#__RefHeading__1071_1307807964)

[**Sample CSV file with cross sectional measures that appear in one
record**
[65](#__RefHeading__225_1286104575)](#__RefHeading__225_1286104575)

[Annex B: Examples of Excel to SDMX conversion
[67](#_APPENDIX_D)](#_APPENDIX_D)

[Annex C: How Excel handles decimal numbers
[69](#_APPENDIX_E_–)](#_APPENDIX_E_–)

[**Excel adheres to the IEEE 754 standard**
[69](#_Toc431229414)](#_Toc431229414)

[**What Excel displays is NOT what is stored internally**
[69](#_Toc431229415)](#_Toc431229415)

[Annex D: The rounding mechanism implemented in Converter
[70](#_APPENDIX_F_–)](#_APPENDIX_F_–)

[Annex E – CSV Input/Output escaping mechanism
[71](#_Toc431229417)](#_Toc431229417)

[Annex F – Converter Web Service and Struval Web Service WSDLs
[72](#_Ref431216025)](#_Ref431216025)

[**2.1** **Converter Web Service:**
[72](#_Toc159321875)](#_Toc159321875)

[**2.2** **Struval Web Service:** [74](#_Toc46407922)](#_Toc46407922)

[**Metadata Metrics** [79](#_Toc30505114)](#_Toc30505114)

[**Converter Transformation Service**
[80](#_Toc81513640)](#_Toc81513640)

[Annex G: Validations done by STRUVAL
[82](#_Toc85613428)](#_Toc85613428)

[**Syntax Validation** [82](#_Toc428884494)](#_Toc428884494)

[**Structural Validation** [82](#_Toc428884495)](#_Toc428884495)

[**Data Validation** [82](#_Toc428884496)](#_Toc428884496)

[Annex H: The structure of a header file
[84](#_Toc477975027)](#_Toc477975027)

[Annex I: The structure of a column mapping file
[85](#_Ref458498641)](#_Ref458498641)

[**Mapping for CSV** [85](#_Toc477975029)](#_Toc477975029)

[**Mapping for FLR** [85](#_Toc46407931)](#_Toc46407931)

[**Mapping for Multilevel CSV** [86](#_Toc495078247)](#_Toc495078247)

[**Mapping for SDMX CSV** [86](#_Toc495078248)](#_Toc495078248)

[**Fixed values example** [87](#_Toc477975031)](#_Toc477975031)

[**Mapping for cross sectional files**
[87](#_Toc477975032)](#_Toc477975032)

[**Mapping for files containing explicit Measures**
[88](#_Toc46407936)](#_Toc46407936)

[Annex J: The structure of an excel parameter sheet mapping file or
sheet [89](#_Toc477975034)](#_Toc477975034)

[Annex K: The structure of a transcoding file
[90](#_Ref458498847)](#_Ref458498847)

[Annex L: Conversion limitations [91](#_Toc477975038)](#_Toc477975038)

[**CSV/FLR limitations** [91](#_Toc477975039)](#_Toc477975039)

[**Limitations for Message Group messages**
[92](#_Toc477975040)](#_Toc477975040)

[**Limitations when converting to/from Cross Sectional**
[93](#_Toc477975041)](#_Toc477975041)

[**Limitations when converting from SDMX 2.1 to other formats**
[93](#_Toc477975042)](#_Toc477975042)

[**Limitations when converting from Gesmes TS**
[93](#_Toc477975043)](#_Toc477975043)

[**Detection of input format** [94](#_Toc477975044)](#_Toc477975044)

[Annex M: How to configure the excel readers (Excel parameter sheet
contents) [95](#_Toc495078260)](#_Toc495078260)

[Annex N: The structure of an excel parameter file
[100](#_Ref458503574)](#_Ref458503574)

[ANNEX O: Supported Conversion [103](#_Toc495078262)](#_Toc495078262)

[Annex P – Structure of a SDMX CSV file
[105](#_Toc495078263)](#_Toc495078263)

[Annex R: Examples of Validation Requests for Web Service
[106](#_Toc495078264)](#_Toc495078264)

[Annex S – Struval Error Messages [108](#_Toc46407951)](#_Toc46407951)

[Annex T – Instructions to Access Registry over HTTPS
[115](#_Toc46407952)](#_Toc46407952)

[**Obtain your own certificate** [115](#_Toc46407953)](#_Toc46407953)

[**Use an existing certificate** [117](#_Toc46407954)](#_Toc46407954)

[Annex U – Reporting Period for SDMX 2.1 Output Formats
[118](#_Toc46407955)](#_Toc46407955)

[Annex V: The structure of a transcoding sheet for Excel parsing
[119](#_Annex_V:_The)](#_Annex_V:_The)

[Annex W: The structure of a properties file
[120](#_Toc46407957)](#_Toc46407957)

[Annex X: Internal SDMX CSV format [121](#_Toc46407958)](#_Toc46407958)

[Annex Y: Character Encoding [122](#_Toc46407959)](#_Toc46407959)

[Annex Z: How Conversion/Validation Handles Excel Formulas
[127](#_Toc46407960)](#_Toc46407960)

[**1.1 Formulas in External Parameter Sheet**
[127](#_Toc46407961)](#_Toc46407961)

[**1.2 Manual Formulas Calculation Detection**
[127](#_Toc46407962)](#_Toc46407962)

#  

# Introduction

The SDMX converter application offers to the user the ability to convert
between all the existing formats of the SDMX version 2.0 standard
(generic, compact, utility and cross-sectional), GESMES (TS, 2.1, DSIS),
CSV and FLR formats (please see [CSV and FLR
limitations](#_CSV_and_FLR)) and
[DSPL](http://code.google.com/apis/publicdata/) - Dataset Publishing
Language.

## **1.1 Structure of this document**

This document is structured along the following chapters.

[Chapter 1](#introduction): Introduction.

[Chapter 2](#__RefHeading__402_1278425962): of this document outlines
the interaction with the Converter web service.

[Chapter 3](#_APPENDIX_A:_Tables): Several appendixes are included at
the end of the document. They contain sections related to the possible
errors generated by the application, how the application is handling the
CSV input/output and some details about the Converter web service.

## **1.2 Supported conversions**

The table below presents all transformations supported by SDMX
Converter:

<table>
<colgroup>
<col style="width: 8%" />
<col style="width: 4%" />
<col style="width: 7%" />
<col style="width: 7%" />
<col style="width: 8%" />
<col style="width: 8%" />
<col style="width: 7%" />
<col style="width: 11%" />
<col style="width: 8%" />
<col style="width: 10%" />
<col style="width: 11%" />
<col style="width: 7%" />
</colgroup>
<tbody>
<tr>
<td style="text-align: right;"><p><strong>Input</strong></p>
<p><strong>Output</strong></p></td>
<td style="text-align: center;"><strong>CSV</strong></td>
<td style="text-align: center;"><p><strong>SDMX</strong></p>
<p><strong>CSV</strong></p></td>
<td style="text-align: center;"><strong>GESMESTS</strong></td>
<td style="text-align: center;"><strong>SDMX GENERIC</strong></td>
<td style="text-align: center;"><strong>SDMX COMPACT</strong></td>
<td style="text-align: center;"><strong>SMDX UTILITY</strong></td>
<td style="text-align: center;"><strong>SDMX CROSS
SECTIONAL</strong></td>
<td style="text-align: center;"><strong>EXCEL</strong></td>
<td style="text-align: center;"><strong>SDMX 2.1 (*****)</strong></td>
<td style="text-align: center;"><strong>Message Group
(******)</strong></td>
<td style="text-align: center;"><p><strong>e</strong></p>
<p><strong>FLR</strong></p></td>
</tr>
<tr>
<td style="text-align: left;">CSV (**)</td>
<td style="text-align: left;">NO</td>
<td style="text-align: center;">YES</td>
<td style="text-align: left;">YES</td>
<td style="text-align: left;">YES</td>
<td style="text-align: left;">YES</td>
<td style="text-align: left;">YES</td>
<td style="text-align: left;">YES(*)</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
</tr>
<tr>
<td style="text-align: left;">SDMX CSV</td>
<td style="text-align: left;">YES</td>
<td style="text-align: center;">NO</td>
<td style="text-align: left;">YES</td>
<td style="text-align: left;">YES</td>
<td style="text-align: left;">YES</td>
<td style="text-align: left;">YES</td>
<td style="text-align: left;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
</tr>
<tr>
<td style="text-align: left;">GESMES/TS</td>
<td style="text-align: left;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: left;">NO</td>
<td style="text-align: left;">YES</td>
<td style="text-align: left;">YES</td>
<td style="text-align: left;">YES</td>
<td style="text-align: left;">YES(*)</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">NO</td>
<td style="text-align: center;">NO</td>
</tr>
<tr>
<td style="text-align: left;">SDMX GENERIC</td>
<td style="text-align: left;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: left;">YES</td>
<td style="text-align: left;">NO</td>
<td style="text-align: left;">YES</td>
<td style="text-align: left;">YES</td>
<td style="text-align: left;">YES(*)</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">NO</td>
<td style="text-align: center;">YES</td>
</tr>
<tr>
<td style="text-align: left;">SDMX COMPACT</td>
<td style="text-align: left;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: left;">YES</td>
<td style="text-align: left;">YES</td>
<td style="text-align: left;">NO</td>
<td style="text-align: left;">YES</td>
<td style="text-align: left;">YES(*)</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">NO</td>
<td style="text-align: center;">YES</td>
</tr>
<tr>
<td style="text-align: left;">SMDX UTILITY</td>
<td style="text-align: left;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: left;">YES</td>
<td style="text-align: left;">YES</td>
<td style="text-align: left;">YES</td>
<td style="text-align: left;">NO</td>
<td style="text-align: left;">YES(*)</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">NO</td>
<td style="text-align: center;">YES</td>
</tr>
<tr>
<td style="text-align: left;">SDMX CROSS-SECTIONAL</td>
<td style="text-align: left;"><p>YES</p>
<p>(*)</p></td>
<td style="text-align: center;">YES</td>
<td style="text-align: left;"><p>YES</p>
<p>(*)</p></td>
<td style="text-align: left;"><p>YES</p>
<p>(*)</p></td>
<td style="text-align: left;"><p>YES</p>
<p>(*)</p></td>
<td style="text-align: left;"><p>YES</p>
<p>(*)</p></td>
<td style="text-align: left;">NO</td>
<td style="text-align: center;">NO</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">NO</td>
<td style="text-align: center;">YES</td>
</tr>
<tr>
<td style="text-align: left;">SDMX 2.1</td>
<td style="text-align: left;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: left;">YES</td>
<td style="text-align: left;">YES</td>
<td style="text-align: left;">YES</td>
<td style="text-align: left;">YES</td>
<td style="text-align: left;"><p>YES</p>
<p>(****)</p></td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">NO</td>
<td style="text-align: center;">NO</td>
<td style="text-align: center;">YES</td>
</tr>
<tr>
<td style="text-align: left;">EXCEL</td>
<td style="text-align: left;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: left;">YES</td>
<td style="text-align: left;">YES</td>
<td style="text-align: left;">YES</td>
<td style="text-align: left;">YES</td>
<td style="text-align: left;">NO</td>
<td style="text-align: center;">NO</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">NO</td>
<td style="text-align: center;">YES</td>
</tr>
<tr>
<td style="text-align: left;">FLR</td>
<td style="text-align: left;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: left;">YES</td>
<td style="text-align: left;">NO</td>
<td style="text-align: left;">YES</td>
<td style="text-align: left;">YES</td>
<td style="text-align: left;">NO</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">NO</td>
</tr>
</tbody>
</table>

> (\*) The selected DSD for these files must support cross-sectional
> messages i.e. having defined cross-sectional measures and
> cross-sectional attachment levels for its components (see SDMX
> standard [www.sdmx.org](http://www.sdmx.org/))
>
> (\*\*)When the output format (CSV, FLR) is a flat file the attributes,
> attached in higher level than observations in the input message are
> omitted.
>
> (\*\*\*\*)The provided DSD has to be valid with Time dimension or
> cross sectional measures.
>
> (\*\*\*\*\*)With exception of SDMX V2.1 formats no other format
> supports multiple datasets in a single data message. Consequently
> Converter only supports conversions of SDMX V2.1 files having a single
> dataset per message. Also conversion from SDMX 2.1 to SDMX 2.0 formats
> is possible only when the DSD is compatible with both formats. The
> compatibility with V2.0 formats is checked in SDMX Source API before
> conversion begins.
>
> (\*\*\*\*\*\*)The Message Group input file should have only one
> dataset reported in the message.

## **1.3 CSV and FLR limitations**

> In order for a flat CSV or FLR file to be converted successfully some
> limitations exist. Each line in such a file represents one record.
> This implies that no new line characters should be present inside the
> data in that record.
>
> However there exist some cases where new line characters can be
> present in data. For example attributes may represent free text data
> that contain new line characters. Below is given a screenshot that
> illustrates this case:
>
> Figure 1 - Sample csv file
>
> In such a case user should suppress all these new line characters from
> the file.
>
> Figure 2 - The csv file after suppressing the new line character
>
> For flat CSV files also the attributes at a higher level than
> Observation are processed.
>
> The user has to repeat the respective attribute on every related
> observation if not the first encountered value is used and the rest
> are ignored. In case the values of the attributes other than the
> Observation level are not the same for the same group or time series
> then a warning is printed in the log. The conversion will be
> successful using the first encountered value.
>
> In the mapping file all the dimensions, attributes, primary measure,
> time reference etc must be provided according to the DSD.
>
> For default mapping the implicit order is: dimensions, time dimension,
> primary measure, observation level attributes, dataset attributes,
> group attributes and series level attributes.
>
> For multilevel files and those containing groups is mandatory to have
> the data ordered - rows for the same series or group are consecutive
> (Input Ordered). Input has to be ordered also when converting to cross
> sectional format.
>
> Please see section about Header Row in section [CSV/FLR
> parameters](#_CSV/FLR_Parameters) for details on how to handle the
> first row of a CSV/FLR file.

## **1.4 Excel limitations**

> For a successful Excel conversion some limitations exist:
>
> \- each series creates a new excel sheet;
>
> \- no support for MIXED;
>
> \- SKIP: the concept is not mapped in the Excel file and should be
> skipped. But this is only for attributes as Dimensions are all
> mandatory.
>
> \- FIX values not displayed;
>
> \- only one parameter sheet accepted;
>
> \- no support for cross sectional measures.

## **1.5 Limitations when converting Message Group SDMX-ML messages**

> The MessageGroup is used to allow more than one data message to be
> included in a single transmission. Currently, Converter supports
> Message Group as input sdmx-ml file for all four different
> representations of reporting datasets: Generic data message, Compact
> data Message, Utility data Message and Cross Sectional Data Message.
> This support has the following limitations when converting Message
> Group sdmx-ml messages:

- The single output format supported for Message Group messages is CSV

- The input sdmx-ml file must have only ONE dataset reported in the
  message<span id="__RefHeading__402_1278425962" class="anchor"></span>

# Using the Converter Web Service

> This section presents the SDMX Converter Web Service and Struval Web
> Service. Specifically, is described how you can build a client to
> invoke the web service and make conversions.

## **SOAP Web services**

> The Web Service interface offers the possibility to expose Converter
> and Struval functionalities on over the World Wide Web. The clients
> can call the application server where the Converter service is
> deployed. The advantage of calling the converter through the web
> service is the interoperability obtained. One client can interact with
> the converter regardless of the client application platform and the
> programming language used. However, SOAP is slower than interacting
> with the other interfaces since datasets are sent over the network and
> the CPU time is shared with other conversion requests. Moreover, the
> overhead of the SOAP and HTTP protocol is added.

## **Web Service Descriptor for Converter (WSDL)**

> To invoke the converter web service a client should be developed that
> will reach the WSDL of the service. The WSDL of the converter web
> service can be viewed at
> *http://url:port/services_name/ConverterWebService?wsdl ,*
> *[http://url:port/services_name/ConverterHTI?wsdl](file:///E:/deliverables/8.4.13/%20http:/url:port/services_name/ConverterHTI)*
> or, for Struval Web Service
> *http://url:port/services_name/StruvalWebService?wsdl*
>
> For example, for the Eurostat environment the URL is 158.167.200.146
> and the port is 7002. Therefore, the WSDL can be viewed at:
>
> <http://158.167.200.146:7002/ConverterWebService/ConverterWebService?wsdl>
>
> A *shortened version* of the WSDL of the SDMX Converter Web service
> would look like below:

\<definitions name="ConverterDS"\>  
\<wsdl:message name="ConvertData"\>  
\<wsdl:part name="parameters" element="ns1:ConvertData"/\>  
\</wsdl:message\>  
\<wsdl:message name="ConvertDataResponse"\>  
\<wsdl:part name="parameters" element="ns1:ConvertDataRespMsg"/\>  
\</wsdl:message\>  
\<wsdl:message name="GetWsVersion"\>  
\<wsdl:part name="parameters" element="tns:GetWsVersion"/\>  
\</wsdl:message\>  
\<wsdl:message name="GetWsVersionResponse"\>  
\<wsdl:part name="parameters" element="tns:GetWsVersionResponse"/\>  
\</wsdl:message\>  
\<wsdl:message name="GetStatus"\>  
\<wsdl:part name="parameters" element="tns:GetStatus"/\>  
\</wsdl:message\>  
\<wsdl:message name="Exception"\>  
\<wsdl:part name="fault" element="tns:Exception"/\>  
\</wsdl:message\>  
\<wsdl:portType name="ConverterDS"\>  
\<wsdl:operation name="ConvertData"\>  
\<wsdl:input message="tns:ConvertData"/\>  
\<wsdl:output message="tns:ConvertDataResponse"/\>  
\<wsdl:fault message="tns:Exception" name="Exception"/\>  
\</wsdl:operation\>  
\<wsdl:operation name="GetWsVersion"\>  
\<wsdl:input message="tns:GetWsVersion"/\>  
\<wsdl:output message="tns:GetWsVersionResponse"/\>  
\<wsdl:fault message="tns:Exception" name="Exception"/\>  
\</wsdl:operation\>  
\<wsdl:operation name="GetStatus"\>  
\<wsdl:input message="tns:GetStatus"/\>  
\<wsdl:output message="tns:GetStatusResponse"/\>  
\<wsdl:fault message="tns:Exception" name="Exception"/\>  
\</wsdl:operation\>  
\</wsdl:portType\>  
\<binding name="ConverterDSServiceBinding" type="tns:ConverterDS"\>  
\<operation name="ConvertData"\>  
\<soap:operation soapAction=""/\>  
\<input\>  
\<soap:body use="literal"/\>  
\</input\>  
\<output\>  
\<soap:body use="literal"/\>  
\</output\>  
\<fault name="Exception"\>  
\<soap:fault name="Exception" use="literal"/\>  
\</fault\>  
\</operation\>  
\<operation name="GetWsVersion"\>  
\<soap:operation soapAction=""/\>  
\<input\>  
\<soap:body use="literal"/\>  
\</input\>  
\<output\>  
\<soap:body use="literal"/\>  
\</output\>  
\<fault name="Exception"\>  
\<soap:fault name="Exception" use="literal"/\>  
\</fault\>  
\</operation\>  
\<operation name="GetStatus"\>  
\<soap:operation soapAction=""/\>  
\<input\>  
\<soap:body use="literal"/\>  
\</input\>  
\<output\>  
\<soap:body use="literal"/\>  
\</output\>  
\<fault name="Exception"\>  
\<soap:fault name="Exception" use="literal"/\>  
\</fault\>  
\</operation\>  
\</binding\>  
\<service name="ConverterDS"\>  
\<port name="ConverterDSService"
binding="tns:ConverterDSServiceBinding"\>  
\<soap:address
location="http://localhost:8080/converter_ws/ConverterWebService"/\>  
\</port\>  
\</service\>  
\</definitions\>

> For a full WSDL please consult Annex F – Converter Web Service and
> Struval Web Service WSDL

## **Using the “ConvertData” method of the Converter web service**

The request for Converter Web Service:

\<soapenv:Envelope
xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
xmlns:v2="http://xmlns.ec.eu/BusinessObjects/ConverterDS/V2/"\>  
\<soapenv:Header/\>  
\<soapenv:Body\>  
\<v2:ConvertData\>  
*\<!--Optional:--\>  *
\<ConvertFromFormat\>?\</ConvertFromFormat\>  
*\<!--Optional:--\>  *
\<ConvertToFormat\>?\</ConvertToFormat\>  
*\<!--Optional:--\>  *
\<ConvertInput\>cid:53095452354\</ConvertInput\>  
*\<!--Optional:--\>  *
\<ServiceParameter timeout="?" expiration="?" defaultVersion="?"\>  
*\<!--Optional:--\>  *
\<DataflowAgency\>?\</DataflowAgency\>  
*\<!--Optional:--\>  *
\<DataflowId\>?\</DataflowId\>  
*\<!--Optional:--\>  *
\<DataflowVersion\>?\</DataflowVersion\>  
*\<!--Optional:--\>  *
\<DateCompatibility\>?\</DateCompatibility\>  
*\<!--Optional:--\>  *
\<Delimiter\>?\</Delimiter\>  
*\<!--Optional:--\>  *
\<OutputDelimiter\>?\</OutputDelimiter\>  
*\<!--Optional:--\>  *
\<FieldSeparationCharacter\>?\</FieldSeparationCharacter\>  
*\<!--Optional:--\>  *
\<OutputFieldSeparationCharacter\>?\</OutputFieldSeparationCharacter\>  
*\<!--Optional:--\>  *
\<Languages\>?\</Languages\>  
*\<!--Optional:--\>  *
\<EscapeCSVOutput\>?\</EscapeCSVOutput\>  
*\<!--Optional:--\>  *
\<ExcelMappingParameter\>cid:1695947443472\</ExcelMappingParameter\>  
*\<!--Optional:--\>  *
\<ExcelType\>?\</ExcelType\>  
*\<!--Optional:--\>  *
\<ExcelTemplate\>cid:293112275294\</ExcelTemplate\>  
*\<!--Optional:--\>  *
\<ExternalExcelParameter\>cid:617752524435\</ExternalExcelParameter\>  
*\<!--Optional:--\>  *
\<GeneratedFileComment\>?\</GeneratedFileComment\>  
*\<!--Optional:--\>  *
\<GesmesWritingTechnique\>?\</GesmesWritingTechnique\>  
*\<!--Optional:--\>  *
\<HeaderFile\>cid:1253726623898\</HeaderFile\>  
*\<!--Optional:--\>  *
\<HeaderRow\>?\</HeaderRow\>  
*\<!--Optional:--\>  *
\<WriteLabels\>?\</WriteLabels\>  
*\<!--Optional:--\>  *
\<HeaderWriting\>?\</HeaderWriting\>  
*\<!--Optional:--\>  *
\<KeyFamilyAgency\>?\</KeyFamilyAgency\>  
*\<!--Optional:--\>  *
\<KeyFamilyId\>?\</KeyFamilyId\>  
*\<!--Optional:--\>  *
\<KeyFamilyVersion\>?\</KeyFamilyVersion\>  
*\<!--Optional:--\>  *
\<LevelNumber\>?\</LevelNumber\>  
*\<!--Optional:--\>  *
\<MappingFile\>cid:46787543057\</MappingFile\>  
*\<!--Optional:--\>  *
\<OutputMappingFile\>cid:1372235405867\</OutputMappingFile\>  
*\<!--Optional:--\>  *
\<NamespacePrefix\>?\</NamespacePrefix\>  
*\<!--Optional:--\>  *
\<NamespaceUri\>?\</NamespaceUri\>  
*\<!--Optional:--\>  *
\<ReportingYearStartDay\>?\</ReportingYearStartDay\>  
*\<!--Optional:--\>  *
\<OrderedFlatInput\>?\</OrderedFlatInput\>  
*\<!--Optional:--\>  *
\<UseXSMeasures\>?\</UseXSMeasures\>  
*\<!--Optional:--\>  *
\<UseExplicitMeasures\>?\</UseExplicitMeasures\>  
*\<!--Optional:--\>  *
\<SpecifyDataflow\>?\</SpecifyDataflow\>  
*\<!--Optional:--\>  *
\<StructureFile\>cid:1149062297177\</StructureFile\>  
*\<!--Optional:--\>  *
\<StructureSetFile\>cid:1399365765270\</StructureSetFile\>  
*\<!--Optional:--\>  *
\<UnescapeCSVInput\>?\</UnescapeCSVInput\>  
*\<!--Optional:--\>  *
\<ErrorIfEmpty\>?\</ErrorIfEmpty\>  
*\<!--Optional:--\>  *
\<UseRegistry\>?\</UseRegistry\>  
*\<!--Optional:--\>  *
\<RegistryUrl\>?\</RegistryUrl\>  
*\<!--Optional:--\>  *
\<RegistryType\>?\</RegistryType\>  
*\<!--Optional:--\>  *
\<Padding\>?\</Padding\>  
*\<!--Optional:--\>  *
\<SdmxHeaderToSdmxCsv\>?\</SdmxHeaderToSdmxCsv\>  
\</ServiceParameter\>  
\</v2:ConvertData\>  
\</soapenv:Body\>  
\</soapenv:Envelope\>

> The parameters that could be given for the invocation of a conversion
> are the following:

<table>
<colgroup>
<col style="width: 25%" />
<col style="width: 27%" />
<col style="width: 47%" />
</colgroup>
<thead>
<tr>
<th style="text-align: left;"><blockquote>
<p><strong>Parameter</strong></p>
</blockquote></th>
<th style="text-align: left;"><blockquote>
<p><strong>Type</strong></p>
</blockquote></th>
<th style="text-align: left;"><blockquote>
<p><strong>Description</strong></p>
</blockquote></th>
</tr>
</thead>
<tbody>
<tr>
<td style="text-align: left;"><blockquote>
<p>ConvertFromFormat</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>String</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>the input format</p>
<p>values: CSV</p>
<p>MULTI_LEVEL_CSV</p>
<p>SDMX_CSV</p>
<p>FLR</p>
<p>GESMES_TS</p>
<p>GENERIC_SDMX</p>
<p>COMPACT_SDMX</p>
<p>UTILITY_SDMX</p>
<p>CROSS_SDMX</p>
<p>GENERIC_DATA_2_1</p>
<p>GENERIC_TS_DATA_2_1</p>
<p>STRUCTURE_SPECIFIC_DATA_2_1</p>
<p>STRUCTURE_SPECIFIC_TS_DATA_2_1</p>
<p>STRUCTURE_SPECIFIC_DATA_3_0</p>
<p>EXCEL</p>
<p>MESSAGE_GROUP</p>
<p>AUTO</p>
</blockquote></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>ConvertToFormat</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>String</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>the output format</p>
<p>values: CSV</p>
<p>MULTI_LEVEL_CSV</p>
<p>SDMX_CSV</p>
<p>SDMX_CSV_2_0</p>
<p>FLR</p>
<p>GESMES_TS</p>
<p>GENERIC_SDMX</p>
<p>COMPACT_SDMX</p>
<p>UTILITY_SDMX</p>
<p>CROSS_SDMX</p>
<p>GENERIC_DATA_2_1</p>
<p>GENERIC_TS_DATA_2_1</p>
<p>STRUCTURE_SPECIFIC_DATA_2_1</p>
<p>STRUCTURE_SPECIFIC_TS_DATA_2_1</p>
<p>STRUCTURE_SPECIFIC_DATA_3_0</p>
<p>EXCEL</p>
</blockquote></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>ConvertInput</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>base64Binary</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>the input of the dataset to be converted</p>
</blockquote></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>ServiceParameter</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>ServiceParameterType</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>auxiliary parameters needed for the conversion</p>
</blockquote></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>ServiceParameter</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>defaultVersion</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>Structure version to be used when multiple dsds/versions inside
structure file.</p>
</blockquote></td>
</tr>
</tbody>
</table>

These are indicated in the WSDL as following:

> \<xs:complexType name="ConvertDataType"\>
>
> \<xs:sequence\>
>
> \<xs:element name="**ConvertFromFormat** " type="xs:string"/\>
>
> \<xs:element name="**ConvertToFormat** " type="xs:string"/\>
>
> \<xs:element name="**ConvertInput**" type="xs:base64Binary"/\>
>
> \<xs:element name="**ServiceParameters**" type="ax24:
> **ServiceParameterType** "/\>
>
> \</xs:sequence\>
>
> \</xs:complexType\>

For the first two arguments a String from the ***Formats*** enumeration
ss class is needed. (some valid values could be: “CSV” or “COMPACT_SDMX”
– both taken from the ***Formats*** java enumeration). The difference is
that for the input the value “AUTO” can be added. If ConvertFromFormat
is missing or it’s value is “AUTO”, Converter WS tries to autodetect the
format of the input file. If the format can not be autodetected, an
error is thrown: "The Format can not be autodetected! Add the correct
format of the input file!"

The **timeout** of ServiceParameter element defines the maximum time
interval the user is willing to wait to get their conversion result. If
there are no result by the end of it, then web service will return a
uuid and a status code will be return to the user.3600 seconds means the
timeout is set to 1h by default.

The **expiration** each conversion result file will be alive for some
time. After this time is off it should expire. This will be used in the
clean up mechanism. The results that have been expired will be cleaned
up by the clean up thread.

The **defaultVersion** represents the default version for structure
element if there is no structure version explicitly declared and if the
structure file contains multiple dsds/dataflows inside. It is not a
required attribute. The rules about what structure will be used in case
of multiple dsds/dataflows are presented below:

<img src="media/image4.png" style="width:6.3in;height:4.49167in"
alt="image-2018-09-14-10-59-15-675" />

By giving the path of the input file you can create a FileInputStream
object which can be converted to a byte array object. For example a
client written in Java:

> FileInputStream inputStream = new FileInputStream(new File(“D:/
> selectedInputFile”));
>
> Byte Array input = new byte \[(int) inputStream.available()\]
>
> inputStream.read(input);

Finally you have to specify a ServiceParameter object in order to define
the auxiliary parameters needed for the conversion. The parameters that
could be set are the following:

<table>
<colgroup>
<col style="width: 23%" />
<col style="width: 18%" />
<col style="width: 58%" />
</colgroup>
<thead>
<tr>
<th style="text-align: left;"><blockquote>
<p><strong>Parameter</strong></p>
</blockquote></th>
<th style="text-align: left;"><blockquote>
<p><strong>Type</strong></p>
</blockquote></th>
<th style="text-align: left;"><blockquote>
<p><strong>Description</strong></p>
</blockquote></th>
</tr>
</thead>
<tbody>
<tr>
<td style="text-align: left;"><blockquote>
<p>DataflowAgency</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>String</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>The agency of the dataflow</p>
</blockquote></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>DataflowId</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>String</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>The id of the dataflow</p>
</blockquote></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>DataflowVersion</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>String</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>The version of the dataflow</p>
</blockquote></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>DateCompatibility</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>String</p>
</blockquote></td>
<td style="text-align: left;"></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>Delimiter</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>String</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>The delimiter (does not apply for FLR) of the input file</p>
</blockquote></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>OutputDelimiter</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>String</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>The delimiter of the output file</p>
</blockquote></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>EscapeCSVOutput</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>String</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>Applicable ONLY for CSV output file. Accepted values: DEFAULT (escape
with double quotes only the values that contain special characters),
ESCAPE_ALL (all values have double quotes), ESCAPE_NONE (values remain
as is, used if all special characters are escaped already).</p>
<p>Default value: DEFAULT.</p>
</blockquote></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>ExcelMappingParameters</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>Byte Array</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>The mapping of the excel parameters</p>
</blockquote></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>ExcelType</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>String</p>
</blockquote></td>
<td style="text-align: left;"></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>ExcelTemplate</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>Data Handler</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>The mandatory template used for conversion with excel output.</p>
</blockquote></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>ExternalExcelParameter</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>Byte Array</p>
</blockquote></td>
<td style="text-align: left;"></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>GeneratedFileComment</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>String</p>
</blockquote></td>
<td style="text-align: left;"></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>GesmesWritingTechnique</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>String</p>
</blockquote></td>
<td style="text-align: left;"></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>HeaderFile</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>Byte Array</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>The header file. If the conversion is done with input one of the
following formats (FLR, EXCEL, CSV, MULTI_LEVEL_CSV, SDMX_CSV) to output
one of the following formats (EXCEL, CSV, MULTI_LEVEL_CSV, SDMX_CSV) the
header file is not necessary as this formats do not include header
information.</p>
</blockquote></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>HeaderWriting</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>boolean</p>
</blockquote></td>
<td style="text-align: left;"><p>Accepted values are ‘true’ or
‘false’.</p>
<ul>
<li><p>When the value is ‘true’, if the input file is of SDMX type, or
CSV, or Excel, the response returns the header information. If the
conversion is done with input one of the following formats (EXCEL, CSV,
MULTI_LEVEL_CSV, SDMX_CSV) to output one of the following formats
(EXCEL, CSV, MULTI_LEVEL_CSV, SDMX_CSV) the parameter is not allowed as
this formats do not include header information.</p></li>
</ul></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>HeaderRow</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>String</p>
</blockquote></td>
<td style="text-align: left;"><ul>
<li><p>For a conversion with CSV /FLR input the value should be one of:
DISREGARD_COLUMN_HEADERS, USE_COLUMN_HEADERS,
NO_COLUMN_HEADERS.</p></li>
<li><p>When USE_COLUMN_HEADERS, is used with CSV/FLR input, then the
column names from the first line of csv will be used to detect the DSD
concepts. There can be more columns than the number of concepts in DSD,
but only those available in DSD will be processed. The rest of the
columns will be ignored.</p></li>
<li><p>For a conversion to CSV from a non-FLAT input file the values
should be one of NO_COLUMN_HEADERS, USE_COLUMN_HEADERS.</p></li>
<li><p>For the special case of a conversion to one FLAT file from
another FLAT file (e.g. from SDMX_CSV to CSV) and when the two files do
not use the same option in the headerRow parameter, converter needs two
values in this parameter, one for the input file and one for the output
file. In that case, the value passed to this parameter is a comma
separated list of two values for the HeaderRow parameter one for the
input file and one for the output file. An example of the case described
above is the following line:<br />
&lt;HeaderRow&gt;USE_COLUMN_HEADERS,OUT_NO_COLUMN_HEADERS&lt;/HeaderRow&gt;<br />
The acceptable values for the HeaderRow parameter are the
following:</p></li>
</ul>
<table>
<colgroup>
<col style="width: 20%" />
<col style="width: 79%" />
</colgroup>
<thead>
<tr>
<th style="text-align: left;">Input possible options</th>
<th style="text-align: left;">Output possible options</th>
</tr>
</thead>
<tbody>
<tr>
<td style="text-align: left;">USE_COLUMN_HEADERS</td>
<td style="text-align: left;">OUT_USE_COLUMN_HEADERS</td>
</tr>
<tr>
<td style="text-align: left;">NO_COLUMN_HEADERS</td>
<td style="text-align: left;">OUT_NO_COLUMN_HEADERS</td>
</tr>
</tbody>
</table>
<blockquote>
<p>and any possible combination of those values. If the user passes only
one value (e.g. USE_COLUMN_HEADERS) in the HeaderRow parameter, then for
converter uses this value both for the input and the output file.</p>
</blockquote></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>KeyFamilyAgency</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>String</p>
</blockquote></td>
<td style="text-align: left;"></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>KeyFamilyId</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>String</p>
</blockquote></td>
<td style="text-align: left;"></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>KeyFamilyVersion</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>String</p>
</blockquote></td>
<td style="text-align: left;"></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>LevelNumber</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>String</p>
</blockquote></td>
<td style="text-align: left;"></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>MappingFile</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>Byte Array</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>The mapping for input file</p>
</blockquote></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>OutputtMappingFile</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>Byte Array</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>The mapping for output file</p>
</blockquote></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>NamespacePrefix</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>String</p>
</blockquote></td>
<td style="text-align: left;"></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>NamespaceUri</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>String</p>
</blockquote></td>
<td style="text-align: left;"></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>ReportingYearStartDay</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>String</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>Available only for SDMX 2.1 output formats. A string of format
“--mm-dd”, containg the month and day the user wants to appear in the
output file’s REPORTING_YEAR_START_DATE attribute in the DataSet. For
example: “--01-01” (representing January 1st) or “--12-31” (representing
the 31<sup>st</sup> of December). Reporting Period will be used only if
the parameter is provided otherwise Gregorian time is used. See Annex U
– Reporting Period for SDMX 2.1 Output Formats</p>
</blockquote></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>OrderedFlatInput</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>String</p>
</blockquote></td>
<td style="text-align: left;"></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>UseXSMeasures</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>boolean</p>
</blockquote></td>
<td style="text-align: left;"><p>Accepted values are ‘true’ or
‘false’.</p>
<ul>
<li><p>When set it to true Cross Measures are expected in the Structure
and in the input data.</p></li>
</ul></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>UseExplicitMeasures</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>boolean</p>
</blockquote></td>
<td style="text-align: left;"><p>Accepted values are ‘true’ or
‘false’.</p>
<ul>
<li><p>When set it to true explicit Measures are expected in the
Structure, in the mapped dimensions and in the input data. This feature
is supported for FLR input files and CSV output files.</p></li>
</ul></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>SpecifyDataflow</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>String</p>
</blockquote></td>
<td style="text-align: left;"></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>StructureFile</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>Byte Array</p>
</blockquote></td>
<td style="text-align: left;"></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>StructureSetFile</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>Byte Array</p>
</blockquote></td>
<td style="text-align: left;">The file with the transcoding
information</td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>UseRegistry</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>boolean</p>
</blockquote></td>
<td style="text-align: left;">Accepted values are ‘true’ or ‘false’</td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>RegistryUrl</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>String</p>
</blockquote></td>
<td style="text-align: left;">Define URL for registry calls</td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>RegistryType</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>String</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>Set the type of Registry. Accepted values are: <em>Empty</em>,
<em>SOAP</em>, <em>REST_V1</em>, <em>REST_V2</em></p>
</blockquote></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>ErrorIfEmpty</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>boolean</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>Accepted values are ‘true’ or ‘false’</p>
<p>When set to false and the action in the dataset is not equal to
‘DELETE’ then if the input file hasn’t got any data rows and any
observations, the file is considered valid. The default value for this
parameter is true and in the case of an empty input file an error is
raised.*</p>
<p>(Explained in more details in the table below.)</p>
</blockquote></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>UnescapeCSVInput</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>String</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>(does not apply for FLR)</p>
</blockquote></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>padding</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>Character</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>Accepted values any character.</p>
<p>Every value has fixed width, padding character is the character with
which the unwritten spaces will be filled.</p>
</blockquote></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>writeLabels</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>String</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>Accepted values ID, BOTH. If not present ID is the default value.</p>
<p>When set to BOTH the labels with IDS will be written in SDMX_CSV
output file. Else only the ID is written in the output.</p>
</blockquote></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>FieldSeparationCharacter</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>String</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>The field separation character applied on SDMX_CSV_2_0/iSDMX_CSV_2_0
or Single Level CSV input files that support SDMX 3.0 features. Must be
different from the delimiter.</p>
</blockquote></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>OutputFieldSeparationCharacter</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>String</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>The field separation character applied on SDMX_CSV_2_0/iSDMX_CSV_2_0
or Single Level CSV output files that support SDMX 3.0 features. Must be
different from the delimiter.</p>
</blockquote></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>Languages</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>Comma delimited list</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>Comma delimited list of preferred languages (default value is ‘en’
applied only on SDMX_CSV_2_0/iSDMX_CSV_2_0 of the output file.</p>
</blockquote></td>
</tr>
<tr>
<td style="text-align: left;"><blockquote>
<p>SdmxHeaderToSdmxCsv</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>String</p>
</blockquote></td>
<td style="text-align: left;"><blockquote>
<p>The user, using the condition “true”, has the ability to transfer all
or a given standard set of elements of the header to SDMX_CSV. Will
include all default SDMX_XML headers as predefined in the
'ordered-header.properties' file starting with the symbol '$' to
indicate that this particular header is a default and must be included
in the output header, keeping the order as is in the file, top-bottom
approach.</p>
<p>&lt;SdmxHeaderToSdmxCsv&gt;true&lt;/SdmxHeaderToSdmxCsv&gt;</p>
<p>In case that the user wants to include specific elements in the
header row, then should refer them to the parameter as a comma delimited
list for example:</p>
<p>&lt;SdmxHeaderToSdmxCsv&gt;Header/ID,Header/Test,Header/Prepared,Header/Sender@Id
&lt;/SdmxHeaderToSdmxCsv&gt;</p>
<p>This specific operation will be valid when the user has selected
SDMX_CSV/iSDMX_CSV as output file.</p>
</blockquote></td>
</tr>
</tbody>
</table>

\* ErrorIfEmpty functionality explained:

## 

<table>
<colgroup>
<col style="width: 15%" />
<col style="width: 23%" />
<col style="width: 20%" />
<col style="width: 19%" />
<col style="width: 20%" />
</colgroup>
<thead>
<tr>
<th>Input</th>
<th>Output</th>
<th></th>
<th></th>
<th></th>
</tr>
</thead>
<tbody>
<tr>
<td></td>
<td>SDMX_CSV</td>
<td>CSV</td>
<td>SS_2.1</td>
<td>COMPACT 2.0</td>
</tr>
<tr>
<td>SDMX_CSV</td>
<td>-</td>
<td><p>errorIfEmpty=true</p>
<p>Error : Collection is empty</p>
<p>errorIfEmpty=false</p>
<p>Successful Conversion (file with header only, no dataset)</p></td>
<td><p>errorIfEmpty=true</p>
<p>Error : Collection is empty</p>
<p>errorIfEmpty=false</p>
<p>Successful Conversion (file with header only, no dataset)</p></td>
<td><p>errorIfEmpty=true</p>
<p>Error : Collection is empty</p>
<p>errorIfEmpty=false</p>
<p>Successful Conversion (file with header only, no dataset)</p></td>
</tr>
<tr>
<td>CSV</td>
<td><p>errorIfEmpty=true</p>
<p>Error : Collection is empty</p>
<p>errorIfEmpty=false</p>
<p>Successful Conversion (empty file, without header row)</p></td>
<td>-</td>
<td><p>errorIfEmpty=true</p>
<p>Error : Collection is empty</p>
<p>errorIfEmpty=false</p>
<p>Successful Conversion (file with header only, no dataset)</p></td>
<td><p>errorIfEmpty=true</p>
<p>Error : Collection is empty</p>
<p>errorIfEmpty=false</p>
<p>Successful Conversion (file with header only, no dataset)</p></td>
</tr>
<tr>
<td><p>SS_2.1</p>
<p>No Dataset</p></td>
<td><p>errorIfEmpty=true</p>
<p>Error : Collection is empty</p>
<p>errorIfEmpty=false</p>
<p>Successful Conversion (file with header only, no dataset)</p></td>
<td><p>errorIfEmpty=true</p>
<p>Error : Collection is empty</p>
<p>errorIfEmpty=false</p>
<p>Successful Conversion (file with header only, no dataset)</p></td>
<td>-</td>
<td><p>errorIfEmpty=true</p>
<p>Error : Collection is empty</p>
<p>errorIfEmpty=false</p>
<p>Successful Conversion (file with header only, no dataset)</p></td>
</tr>
<tr>
<td>SS_2.1<br />
&lt;na_:DataSet&gt;&lt;/na_:DataSet&gt;</td>
<td><p>errorIfEmpty=true</p>
<p>Error : Collection is empty</p>
<p>errorIfEmpty=false</p>
<p>Successful Conversion (file with header only, no dataset)</p></td>
<td><p>errorIfEmpty=true</p>
<p>Error : Collection is empty</p>
<p>errorIfEmpty=false</p>
<p>Successful Conversion (file with header only, no dataset)</p></td>
<td>-</td>
<td><p>errorIfEmpty=true</p>
<p>Error : Collection is empty</p>
<p>errorIfEmpty=false</p>
<p>Successful Conversion (file with header and dataset)</p></td>
</tr>
<tr>
<td>SS_2.1<br />
&lt;na_:DataSet COMMENT_DSET="BlaBla"&gt;<br />
&lt;/na_:DataSet&gt;<br />
&lt;/CompactData&gt;</td>
<td><p>errorIfEmpty=true</p>
<p>Error : Collection is empty</p>
<p>errorIfEmpty=false</p>
<p>Successful Conversion (file with header only, no dataset)</p></td>
<td><p>errorIfEmpty=true</p>
<p>Error : Collection is empty</p>
<p>errorIfEmpty=false</p>
<p>Successful Conversion (file with header only, no dataset)</p></td>
<td>-</td>
<td><p>errorIfEmpty=true</p>
<p>Error : Collection is empty</p>
<p>errorIfEmpty=false</p>
<p>Successful Conversion (file with header and dataset including comment
attribute)</p></td>
</tr>
<tr>
<td><p>SS_2.1</p>
<p>&lt;na_:DataSet COMMENT_DSET="Bla Bla"&gt;</p>
<p>Series (only)</p>
<p>&lt;/na_:DataSet&gt;</p>
<p>&lt;/CompactData&gt;</p></td>
<td><p>errorIfEmpty=true</p>
<p>Error : Collection is empty</p>
<p>errorIfEmpty=false</p>
<p>Successful Conversion (file with header only, no dataset)</p></td>
<td><p>errorIfEmpty=true</p>
<p>Error : Collection is empty</p>
<p>errorIfEmpty=false</p>
<p>Successful Conversion (file with header only, no dataset)</p></td>
<td>-</td>
<td><p>errorIfEmpty=true</p>
<p>Error : Collection is empty</p>
<p>errorIfEmpty=false</p>
<p>Successful Conversion (file with header and dataset including comment
attribute and series)</p></td>
</tr>
<tr>
<td><p>SS_2.1</p>
<p>&lt;na_:DataSet COMMENT_DSET="Bla Bla"&gt;</p>
<p>Series and Groups</p>
<p>No Observations</p>
<p>&lt;/na_:DataSet&gt;</p></td>
<td><p>errorIfEmpty=true</p>
<p>Error : Collection is empty</p>
<p>errorIfEmpty=false</p>
<p>Successful Conversion (file with header only, no dataset)</p></td>
<td><p>errorIfEmpty=true</p>
<p>Error : Collection is empty</p>
<p>errorIfEmpty=false</p>
<p>Successful Conversion (file with header only, no dataset)</p></td>
<td>-</td>
<td><p>errorIfEmpty=true</p>
<p>Error : Collection is empty</p>
<p>errorIfEmpty=false</p>
<p>Successful Conversion (file with header and dataset including comment
attribute, series and groups)</p></td>
</tr>
<tr>
<td><p>COMPACT 2.0</p>
<p>No Dataset</p></td>
<td><p>errorIfEmpty=true</p>
<p>Error : Collection is empty</p>
<p>errorIfEmpty=false</p>
<p>Successful Conversion (file with header only, no dataset)</p></td>
<td><p>errorIfEmpty=true</p>
<p>Error : Collection is empty</p>
<p>errorIfEmpty=false</p>
<p>Successful Conversion (file with header only, no dataset)</p></td>
<td><p>errorIfEmpty=true</p>
<p>Error : Collection is empty</p>
<p>errorIfEmpty=false</p>
<p>Successful Conversion (file with header only, no dataset)</p></td>
<td>-</td>
</tr>
<tr>
<td><p>COMPACT 2.0</p>
<p>&lt;na_:DataSet&gt;</p>
<p>&lt;/na_:DataSet&gt;</p></td>
<td><p>errorIfEmpty=true</p>
<p>Error : Collection is empty</p>
<p>errorIfEmpty=false</p>
<p>Successful Conversion (file with header only, no dataset)</p></td>
<td><p>errorIfEmpty=true</p>
<p>Error : Collection is empty</p>
<p>errorIfEmpty=false</p>
<p>Successful Conversion (file with header only, no dataset)</p></td>
<td><p>errorIfEmpty=true</p>
<p>Error : Collection is empty</p>
<p>errorIfEmpty=false</p>
<p>Successful Conversion (file with header and dataset)</p></td>
<td>-</td>
</tr>
<tr>
<td><p>COMPACT 2.0</p>
<p>&lt;na_:DataSet COMMENT_DSET="Bla Bla"&gt;</p>
<p>&lt;/na_:DataSet&gt;</p></td>
<td><p>errorIfEmpty=true</p>
<p>Error : Collection is empty</p>
<p>errorIfEmpty=false</p>
<p>Successful Conversion (file with header only, no dataset)</p></td>
<td><p>errorIfEmpty=true</p>
<p>Error : Collection is empty</p>
<p>errorIfEmpty=false</p>
<p>Successful Conversion (file with header only, no dataset)</p></td>
<td><p>errorIfEmpty=true</p>
<p>Error : Collection is empty</p>
<p>errorIfEmpty=false</p>
<p>Successful Conversion (file with header and dataset including comment
attribute)</p></td>
<td>-</td>
</tr>
<tr>
<td><p>COMPACT 2.0</p>
<p>&lt;na_:DataSet COMMENT_DSET="Bla Bla"&gt;</p>
<p>Series (only)</p>
<p>&lt;/na_:DataSet&gt;</p></td>
<td><p>errorIfEmpty=true</p>
<p>Error : Collection is empty</p>
<p>errorIfEmpty=false</p>
<p>Successful Conversion (file with header only, no dataset)</p></td>
<td><p>errorIfEmpty=true</p>
<p>Error : Collection is empty</p>
<p>errorIfEmpty=false</p>
<p>Successful Conversion (file with header only, no dataset)</p></td>
<td><p>errorIfEmpty=true</p>
<p>Error : Collection is empty</p>
<p>errorIfEmpty=false</p>
<p>Successful Conversion (file with header and dataset including comment
attribute and series</p></td>
<td>-</td>
</tr>
<tr>
<td><p>COMPACT 2.0</p>
<p>&lt;/CompactData&gt;</p>
<p>&lt;na_:DataSet COMMENT_DSET="Bla Bla"&gt;</p>
<p>Series and Groups</p>
<p>No Observation</p>
<p>&lt;/na_:DataSet&gt;</p>
<p>&lt;/CompactData&gt;</p></td>
<td><p>errorIfEmpty=true</p>
<p>Error : Collection is empty</p>
<p>errorIfEmpty=false</p>
<p>Successful Conversion (file with header only, no dataset)</p></td>
<td><p>errorIfEmpty=true</p>
<p>Error : Collection is empty</p>
<p>errorIfEmpty=false</p>
<p>Successful Conversion (file with header only, no dataset)</p></td>
<td><p>errorIfEmpty=true</p>
<p>Error : Collection is empty</p>
<p>errorIfEmpty=false</p>
<p>Successful Conversion (file with header and dataset including comment
attribute,</p>
<p>Series and groups)</p></td>
<td>-</td>
</tr>
</tbody>
</table>

If the DSD is to be retrieved from SDMX Registry then the appropriate
configuration should be done in the config.txt file that resides in the
‘package/params/’directory. The Registry URL, the Registry Action and
the proxy setting should be set in the config.txt file. (Please consult
the SDMX Converter Installation Guide Section 4). Also if the registry
is over https and needs certificate in trust_store please check Annex T
– Instructions to Access Registry over HTTPS.

The above parameters are depicted in the WSDL:

> \<xs:complexType name="ServiceInputParams"\>
>
> \<xs:sequence\>
>
> \<xs:element name="**DataflowAgency**" type="xs:string" minOccurs="0"
> /\>
>
> \<xs:element name="**DataflowId**" type="xs:string" minOccurs="0" /\>
>
> \<xs:element name="**DataflowVersion**" type="xs:string" minOccurs="0"
> /\>
>
> \<xs:element name="**DateCompatibility**" type="xs:string"
> minOccurs="0" /\>
>
> \<xs:element name="**Delimiter**" type="xs:string" minOccurs="0" /\>
>
> \<xs:element name="**FieldSeparationCharacter**" type="xs:string"
> minOccurs="0" /\>
>
> \<xs:element name="**OutputFieldSeparationCharacter**"
> type="xs:string" minOccurs="0"/\>
>
> \<xs:element name="**Languages**" type="xs:string" minOccurs="0" /\>
>
> \<xs:element name="**EscapeCSVOutput**" type="xs:string" minOccurs="0"
> /\>
>
> \<xs:element name=**"ExcelMappingParameters"**
> type=**"**xs:base64Binary**"** minOccurs=**"0"**/\>
>
> \<xs:element name=**"ExcelType"** type=**"**xs:string**"**
> minOccurs=**"0"** /\>
>
> \<xs:element name=**"ExcelTemplate"** type=**"** xs:base64Binary**"**
> minOccurs=**"0"** /\>
>
> \<xs:element name=**"HeaderRow"** type=**"**xs:string**"**
> minOccurs=**"0"** /\>
>
> \<xs:element name=**"ExternalExcelParameter"**
> type=**"**xs:base64Binary**"** minOccurs=**"0"**/\>
>
> \<xs:element name="**GeneratedFileComment**" type="xs:string"
> minOccurs="0" /\>
>
> \<xs:element name="**GesmesWritingTechnique**" type="xs:string"
> minOccurs="0" /\>
>
> \<xs:element name="**HeaderFile**" type="xs:base64Binary"
> minOccurs="0" /\>
>
> \<xs:element name="**HeaderWriting**" type="xs:boolean" /\>
>
> \<xs:element name="**KeyFamilyAgency**" type="xs:string" minOccurs="0"
> /\>
>
> \<xs:element name="**KeyFamilyId**" type="xs:string" minOccurs="0" /\>
>
> \<xs:element name="**KeyFamilyVersion**" type="xs:string"
> minOccurs="0" /\>
>
> \<xs:element name="**LevelNumber**" type="xs:string" minOccurs="0" /\>
>
> \<xs:element name="**MappingFile**" type="xs:base64Binary"
> minOccurs="0" /\>
>
> \<xs:element name="**OutputMappingFile**" type="xs:base64Binary"
> minOccurs="0" /\>
>
> \<xs:element name="**NamespacePrefix**" type="xs:string" minOccurs="0"
> /\>
>
> \<xs:element name="**NamespaceUri**" type="xs:string" minOccurs="0"
> /\>
>
> \<xs:element name="**ReportingYearStartDay**" type="xs:string"
> minOccurs="0"/\>
>
> \<xs:element name="**OrderedFlatInput**" type="xs:string"
> minOccurs="0" /\>
>
> \<xs:element name ="**UseXSMeasures**" type="xs:string" minOccurs="0"
> /\>
>
> \<xs:element name ="**UseExplicitMeasures**" type="xs:string"
> minOccurs="0" /\>
>
> \<xs:element name="**SpecifyDataflow**" type="xs:string" minOccurs="0"
> /\>
>
> \<xs:element name="**StructureFile**" type="xs:base64Binary"
> minOccurs="0" /\>
>
> \<xs:element name="**StructureSetFile**" type="xs:base64Binary"
> minOccurs="0" /\>
>
> \<xs:element name="**UnescapeCSVInput**" type="xs:string"
> minOccurs="0" /\>
>
> \<xs:element name="**ErrorIfEmpty**" minOccurs="0" type="xs:string"/\>
>
> \<xs:element name="**UseRegistry**" type="xs:string" minOccurs="0" /\>
>
> \<xs:element name="**RegistryUrl**" type="xs:string" minOccurs="0" /\>
>
> \<xs:element name="**RegistryType**" type="xs:string" minOccurs="0"
> /\>
>
> \<xs:element name="**Padding**" type="xs:string" minOccurs="0" /\>
>
> \</xs:sequence\>
>
> \<xs:attribute name="**timeout**" type="xsd:string"/\>
>
> \<xs:attribute name="expiration" type="xsd:string"/\>
>
> \<xs:attribute name="**defaultVersion**" type="xsd:string"/\>
>
> \</xs:complexType\>
>
> The byte array StructureFile, HeaderFile, MappingFile and
> StructureSetFile can be read through a FileInputStream object, given
> the specific file path, and be converted into a byte array object in
> the same way as we described for the byte array input parameter.
>
> The web service method
>
> **ConvertData(String from, String to, byte array input,
> ServiceParameter params)**

returns a ConverterOutputResponse object that contains possibly 3 byte
array outputs which is the converted file, the header information or the
flr output mapping file. This is depicted in the following snapshot of
the WSDL:

\<xs:complexType name="ConverterOutputResponseRespMsgType"\>  
\<xs:sequence\>  
\<xs:element minOccurs="1" name="StatusResponse"
type="ns1:StatusResponseType"/\>  
\<xs:element minOccurs="0" name="Version" type="xs:string"/\>  
\<xs:element minOccurs="0" name="ConversionOutputFile"
type="swaRef:swaRef"  
xmime:expectedContentTypes="application/octet-stream"/\>  
\<xs:element minOccurs="0" name="ConversionOutputHeader"
type="swaRef:swaRef"  
xmime:expectedContentTypes="application/octet-stream"/\>  
\<xs:element minOccurs="0" name="ConversionOutputMapping"
type="swaRef:swaRef"  
xmime:expectedContentTypes="application/octet-stream"/\>  
\</xs:sequence\>  
\<xs:attribute name="IgnoredObservationCount" type="xs:int"/\>  
\<xs:attribute name="ObservationCount" type="xs:int"/\>  
\</xs:complexType\>

> You can write in a file the byte array output in the following way
> (Java based client):
>
> FileOutputStream fileoutStream = new FileOutputStream(new File(“D:/
> selectedInputFile”));
>
> fileoutStream.write(outpout);

## **Using the “GetWsVersion” method of the Converter web service**

The method takes no input parameters.

The web service method

> **GetWsVersion()**
>
> returns a String object that represents the current version of the
> Converter. This is depicted in the following snapshot of the WSDL:
>
> \<message name="GetWsVersion"\>
>
> \<part name="parameters" element="tns:GetWsVersion"/\>
>
> \</message\>
>
> \<message name="GetWsVersionResponse"\>
>
> \<part name="parameters" element="tns:GetWsVersionResponse"/\>
>
> \</message\>
>
> \<portType name="ConverterDS"\>
>
> \<operation name="GetWsVersion"\>
>
> \<input
> wsam:Action="http://xmlns.ec.eu/BusinessActivityService/ConverterBAS/V1/ConverterDS/GetWsVersionRequest"
> message="tns:GetWsVersion"/\>
>
> \<output
> wsam:Action="http://xmlns.ec.eu/BusinessActivityService/ConverterBAS/V1/ConverterDS/GetWsVersionResponse"
> message="tns:GetWsVersionResponse"/\>
>
> \<fault message="tns:Exception" name="Exception"
> wsam:Action="http://xmlns.ec.eu/BusinessActivityService/ConverterBAS/V1/ConverterDS/GetWsVersion/Fault/Exception"/\>
>
> \</operation\>
>
> \</portType\>

**Using asynchronous method of the ConverterWebService**

<img src="media/image5.png" style="width:6.26875in;height:2.26597in"
alt="A screen shot of a computer Description automatically generated" />

Conversion Request with Timeout: The user submits a conversion request
with the timeout and expiration attributes included within the
ServiceParameter element. The service attempts to complete the
conversion within the specified timeout period. If the conversion is
successful within the timeout, the result is returned immediately. If
the conversion exceeds the timeout duration, the service returns a job
ID instead of the conversion result, indicating that the conversion
process will continue asynchronously.

The job ID represents the ongoing conversion task. Users can use the
getStatus method, providing the job ID to query the current status of
the conversion process.

<img src="media/image6.png" style="width:6.26875in;height:1.69861in"
alt="A screenshot of a computer Description automatically generated" />

In this example, the <span class="mark">RequestId</span> is the job ID
returned when the conversion timed out. The
<span class="mark">getStatus</span> request checks the current status of
the conversion. The response from the getStatus request includes the
current status and an estimated time for completion if the conversion is
still in progress.

## **A sample C# web service client for “ConvertData”**

> A C# client invoking the SDMX Web service, in order to perform a
> conversion from an SDMX Compact to a CSV is provided below:
>
> ![](media/image7.emf)
>
> To run the sample conversion, one has 2 options:

- Either by providing the COMPACT_SDMS input file, the Data Structure,
  and the CSV output file in the
  sample_ws_client.net/CONVERTERTool/CONVERTERTool/Properties/launchSettings.json
  as shown in the screenshot below:

> <img src="media/image8.png" style="width:6.30764in;height:4.33056in" />

- Or by simply running the project in Visual Studio once they have
  opened the project’s solution
  ("usersDirectory…\sample_ws_client.net\CONVERTERTool\CONVERTERTool.sln")

> <img src="media/image9.png" style="width:6.30764in;height:2.39097in" />
>
> In this case the sample data from ToolData directory are being used
> for the conversion.
>
> <img src="media/image10.png" style="width:2.17519in;height:2.33354in" />
>
> If someone needs to change the parameters of the template request this
> is the file they should edit:
>
> <img src="media/image11.png" style="width:6.30764in;height:1.86875in" />
>
> The Converter Web Service wsdl could be inserted in the following
> file:
>
> <img src="media/image12.png" style="width:6.26721in;height:1.25844in" />

## **A sample C# web service client for “ValidateData”**

> A C# client invoking the SDMX Web service, in order to perform a
> conversion from an SDMX_ML file is provided in the source files below:
>
> ![](media/image13.emf)
>
> To run an example attach the input file and the structure file:
>
> <img src="media/image14.png" style="width:4.6875in;height:3.06043in" />
>
> If someone needs to change the parameters of the template request this
> is the file they should edit:
>
> <img src="media/image15.png" style="width:6.30208in;height:3.13542in" />

## **Using the “ValidateData” method of the Struval web service**

The “validate” method performs a series of checks on its input:

1.  Validation of the DSD which will be further used in the SDMX message
    validation:

    1.  XML syntax validation

    2.  DSD against the XSD

    3.  SdmxSource validation checks

2.  for the SDMX message:

- XML syntax validation

- SDMX data format specific validation

- data validation

- validation against the constraints

When using the validate method the following checks are performed, for
detailed explanation of the error messages see [Annex S](#_Annex_S_–):

###  **“ValidateData” method parameters**

The request for Struval Web Service:

> \<soapenv:Envelope
> xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
> xmlns:v3="http://xmlns.ec.eu/BusinessActivityService/StruvalBAS/V3"
> xmlns:v31="http://xmlns.ec.eu/BusinessObjects/StruvalDS/V3/"\>  
> \<soapenv:Header/\>  
> \<soapenv:Body\>  
> \<v3:ValidateData timeout="?" expiration="?"\>  
> *\<!--Optional:--\>*  
> \<Input type="?" defaultVersion="?"\>  
> \<v31:InputFile\>cid:1171815129714\</v31:InputFile\>  
> *\<!--Optional:--\>*  
> \<v31:InputConfig\>  
> *\<!--Zero or more repetitions:--\>*  
> \<v31:Config type="?"\>  
> *\<!--Optional:--\>*  
> \<v31:configFile\>cid:22690235226\</v31:configFile\>  
> \</v31:Config\>  
> \</v31:InputConfig\>  
> \</Input\>  
> *\<!--Optional:--\>*  
> \<StructureConfig\>  
> *\<!--You have a CHOICE of the next 2 items at this level--\>*  
> \<v31:Structure agency="?" id="?" version="?"\>  
> \<v31:StructureFile\>cid:524260528173\</v31:StructureFile\>  
> \</v31:Structure\>  
> \<v31:Registry url="?" agency="?" id="?" version="?" type="?"/\>  
> *\<!--Optional:--\>*  
> \<v31:IsDataFlow\>?\</v31:IsDataFlow\>  
> \</StructureConfig\>  
> \<MaximumErrorNumber\>?\</MaximumErrorNumber\>  
> \</v3:ValidateData\>  
> \</soapenv:Body\>  
> \</soapenv:Envelope\>

The **timeout** of ValidateData element defines the maximum time
interval the user is willing to wait to get their validation result. If
there are no result by the end of it, then web service will return a
uuid and a status code will be return to the user.3600 seconds means the
timeout is set to 1h by default.

The **expiration** each validation result will be alive for some time.
After this time is off it should expire. This will be used in the clean
up mechanism. The results that have been expired will be cleaned up by
the clean up thread.

The **type** of *InputFile* represents the format of the input and can
be anyone of the values:

• SDMX_ML (for XML messages Compact 2.0, Generic 2.0, Utility 2.0, Cross
Sectional 2.0, StructureSpecific 2.1, StructureSpecificTS
2.1,GenericData 2.1 and Generic TS Data 2.1) ;

- CSV for single level csv;

- SDMX_CSV;

- MULTI_LEVEL_CSV;

- XLS for Excel pre-2007;

- XLSX for Excel +2007 .xlsx and .xlsm;

- FLR;

- SDMX_EDI for gesmes/ts;

- AUTO for autodetection

The default value for **type** is AUTO.

The **defaultVersion** represents the default version for structure
element if there is no structure version explicitly declared and if the
structure file contains multiple dsds/dataflows inside. The rules about
what structure will be used in case of multiple dsds/dataflows are
presented below:

<img src="media/image4.png" style="width:6.3in;height:4.49167in"
alt="C:\Users\Morgan\AppData\Local\Microsoft\Windows\INetCache\Content.Word\image-2018-09-14-10-59-15-675.png" />

If type is missing or it’s value is “AUTO”, Converter WS tries to
autodetect the type of the input file. If the type can not be
autodetected, an error is thrown: "The type of the input file can not be
autodetected! Add the correct type of the input file!".

The *InputConfig* parameters are used for validating non SDMX_ML. For
CSV, SDMX_CSV MULTI_LEVEL_CSV, EXCEL and FLR configuration files
(*configFile*) are used for loading the configuration parameters.

The **type** of *configFile is:*

- mapping - the xml file contains the mapping used in csv/flr
  validation;

- transcoding - the xml file contains the transcoding data used in
  csv/flr validation;

- parameters - the properties file contains the validation parameters
  for the input file (of type CSV, SDMX_CSV MULTI_LEVEL_CSV, FLR,
  SDMX_ML,EXCEL) (see Anexes W for an example of how csv.properties or
  flr.properties look like).

*The following csv parameters appear in the properties file:*

1.  csv.delimiter – the delimiter used in the csv input file

2.  csv.headerrow - values from DISREGARD_COLUMN_HEADERS,
    USE_COLUMN_HEADERS, NO_COLUMN_HEADERS, OUT_USE_COLUMN_HEADERS(in a
    conversion from one FLAT file to another FLAT file),
    OUT_NO_COLUMN_HEADERS(in a conversion from one FLAT file to another
    FLAT file);

3.  csv.level – the level of the csv, default value is 1

4.  csv.quotecharacter

5.  fieldSeparationCharacter - The field separation character applied on
    SDMX_CSV_2_0/iSDMX_CSV_2_0 or Single Level CSV files that support
    SDMX 3.0 features. Must be different from the delimiter.

> for SDMX_CSV

1.  default.validation.inlineReportFormat – property used to determine
    the response’s output format.

> A\) The old struval inline format(when property set to true)
>
> B\) The new report format containing only the MSD based report as an
> attachment in the response(when property set to false).

1.  validation.csv.allowAdditionalColumns – this parameter concerns all
    CSV flavors. When validating an SDMX-CSV file or a CSV file using
    column headers, in case the user has by mistake misnamed the name of
    a column corresponding to an optional attribute/concept, STRUVAL
    will not raise an error and will ignore the concerned column. For
    instance, the values in an SDMX-CSV file are put in a column called
    “VALUE” instead of “OBS_VALUE”. This column is then ignored, the
    file is considered valid and converted without any values for
    OBS_VALUE. This is in theory correct, as the SDMX-CSV standard
    allows users to include additional columns with column names that do
    not correspond to a concept in the DSD, but it can be annoying, as
    it can easily lead to cases where the incoming file seems to have
    several missing optional attributes due to a misspelling in the
    header. Therefore, this parameter has been created in order to
    provide to the user the option of applying a stricter validation,
    i.e. reject any file that has columns that do not correspond to
    anything in the DSD.

- **Files without Header Rows**: When a file does not contain a header
  row and the concepts are obtained from a provided mapping, an error
  will be raised if there are more columns in the file than those
  declared in the mapping. In other words, if any column is not used in
  the mapping and the flag allow additional is set to false, an error
  will occur.

- **MULTI_LEVEL_CSV Files**: For MULTI_LEVEL_CSV files, an error will be
  raised if there are more columns in any line of the file than those
  declared for that level in the mapping. Each level must adhere
  strictly to the column count specified in the mapping when the flag
  allow additional is set to false.

- **Simple CSV Files**: In the case of Simple CSV files with no header
  and no mapping, an error will be raised (while allow Additional set to
  false) if there are more columns in the file than the total number of
  concepts in the Data Structure Definition (DSD), including optional
  concepts.

1.  validation.csv. validateCSVheaders- This option applies only for
    simple CSV file validation using mapping. We have an option to
    validate that each column in the header row matches the concept name
    mapped to it. It is available for use only when user selects “Use
    header” in the Header Row section and it is false by default.  
    In STRUVAL, we used to have two ways of associating CSV columns to
    concepts in the DSD:  
    - We could use the column names in the CSV file. If we were doing
    this, we could not guarantee that columns were in a given order and
    we could not guarantee that columns for optional attributes were
    present.  
    - We could use a specific mapping (e.g. by saying that column 1
    corresponds to one concept, column 2 to another etc). In this case
    we were guaranteeing the column order, but we could not guarantee
    that the user had used the right column names in the header. This
    therefore meant that we might have had an issue in the downstream
    tools that read the data based on the column name.  
    In the end, with the current options we could not simultaneously
    guarantee that the file would come with columns in a certain order
    and with certain column names. Therefore, we added this option,
    validateCSVheaders, in order to have an option when validating CSV
    that says that the validation should be stricter, i.e. guarantee
    both a given order and given column names

2.  For reporting an error when a Single Level CSV an SDMX_CSV file has
    all the values empty in a row set the following property to true. By
    default this property is set to false.

> csv.errorIfDataValuesEmpty = true.

1.  errorIfEmpty - When set to false if the input file hasn’t got any
    data rows and observations the file is considered valid. The default
    value for this parameter is true and in the case of an empty input
    file an error is raised.

> *The following flr parameters appear in the properties file:*

1.  flr.headerrow - values from DISREGARD_COLUMN_HEADERS,
    USE_COLUMN_HEADERS, NO_COLUMN_HEADERS;

2.  flr.expilicitmeasures – values ‘true’ or ‘false’ if explicit
    measures exist in the mapping and the input file.

3.  validation.inlineReportFormat – property used to determine the
    response’s output format.

> A\) The old struval inline format(when property set to true)
>
> B\) The new report format containing only the MSD based report as an
> attachment in the response(when property set to false).

1.  fieldSeparationCharacter - The field separation character applied on
    FLR files that support SDMX 3.0 features. Must be different from the
    padding character.

2.  errorIfEmpty - When set to false if the input file hasn’t got any
    data rows and observations the file is considered valid. The default
    value for this parameter is true and in the case of an empty input
    file an error is raised.

*The following xml parameters appear in the properties file:*

1.  validation.inlineReportFormat – property used to determine the
    response’s output format.

> A\) The old struval inline format(when property set to true)
>
> B\) The new report format containing only the MSD based report as an
> attachment in the response(when property set to false).

1.  errorIfEmpty - When set to false if the input file hasn’t got any
    data rows and observations the file is considered valid. The default
    value for this parameter is true and in the case of an empty input
    file an error is raised.

When the input file is of type EXCEL, can attach a parameters file of
type xlsx/xlsm or parameter.properties. The xlsx/xlsm file can contain a
mapping sheet, a parameters sheet, or both (see Anexes C for examples of
how the mapping and the parameters sheets look like). The parameter
properties file includes only the errorIfEmpty Boolean parameter, which
defaults to true and raises an exception if triggered. If set to false,
this error will not be raised during execution.

As for the structure definition, the web service request accepts both a
DSD or a Dataflow. They can be provided using *Registry* or
*StructureFile*, but not simultaniously (the webservice user will get a
xsd validation error):

• Structure from file in the *StructureFile* parameter. In this case
*agency*, *id* and *version* can be provided, although they are not
mandatory. This is especially useful when there are more datastructures
available in the structure file. If there is only one structure, then it
will be used by default, otherwise, when there are multiple structures,
sdmxsource autodetection mechanism will try to detect the appropriate
structure.

• retrieved from the *Registry*. For Registry *agency*, *id* and
*version* are mandatory to be able to identify the structure to be
downloaded from registry. *Url* attribute of Registry parameter is
optional. If it not provided a default url from the server will be used
for downloading the structure. The type attribute of the registry can
define the type of the registry that we send the query if it is SOAP,
REST_V1, REST_V2.

It is expected that the identified structure to match the structure
reference from the input file in case it exists. Otherwise an error will
be obtained indicating this situation.

*IsDataflow* is optional and by default its value is false.

The *MaximumErrorNumber* is mandatory and it is used for stopping the
validation algorithm after this number was reached.

### **File type checks**

The first check is about the file type given and its validity with the
attached input file. When the request parameter **\<v21:InputFile
type="?" defaultVersion="?"\>** the format of the input file is taken
from the type parameter.

The **type** of *InputFile* represents the format of the input and can
be anyone of the values:

• SDMX_ML (for XML messages Compact 2.0, Generic 2.0, Utility 2.0, Cross
Sectional 2.0, StructureSpecific 2.1, StructureSpecificTS
2.1,GenericData 2.1 and Generic TS Data 2.1) ;

- CSV for single level csv;

- SDMX_CSV;

- MULTI_LEVEL_CSV;

- XLS for Excel pre-2007;

- XLSX for Excel +2007 .xlsx and .xlsm;

- FLR;

- SDMX_EDI for gesmes/ts;

- AUTO for autodetection

The default value for **type** is AUTO.

To determine the format of the file given we check the contents of the
input file. If for example the selected type is ” SDMX_ML” and the
attached file is CSV then the csv will be parsed as xml file and a error
will be thrown.

### Checks for specific inputs

Every validation performs different checks that depend from the type of
the input or the family that file belongs. For example in a file that
belongs to CSV family a check is performed if the file doesn’t have any
row of data:

\<ns5:ReturnCode\>1\</ns5:ReturnCode\>

\<ns5:Error code="140" messageId="001" fatal="true" class="UNKNOWN"\>

\<ns5:Description\>Collection is empty\</ns5:Description\>

\<ns5:Detail\>The STRUVAL service is not able to process the inputs due
to an internal server error\</ns5:Detail\>

\</ns5:Error\>

For a specific file type checks:

#### **CSV specific checks**

For type=***<span class="mark">CSV</span>*** which means that the input
expected is a single level CSV a configuration parameters file is
needed. If a parameters file is not attached then error will be thrown,
to inform the user that a parameter file is needed:

\<ns5:ReturnCode\>-2\</ns5:ReturnCode\>

\<ns5:Error code="500" messageId="001" fatal="true" class="UNKNOWN"\>

\<ns5:Description\>For a correct CSV, MULTI_LEVEL_CSV , SDMX_CSV or FLR
validation, please provide input configuration!

\</ns5:Description\>

\<ns5:Detail\>The STRUVAL service is not able to process the inputs due
to an internal server error\</ns5:Detail\>

\</ns5:Error\>

The parameters config file for csv contains the following:

1.  csv.delimiter – the delimiter used in the csv input file

2.  csv.headerrow - values from DISREGARD_COLUMN_HEADERS,
    USE_COLUMN_HEADERS, NO_COLUMN_HEADERS;

3.  csv.level – the level of the csv, default value is 1

4.  csv.quotecharacter

Validation checks will be performed for all the parameters in the
configuration file of the csv. For example if the delimeter of the input
file is other from the delimeter that is inside the configuration file
the following error will be thrown:

\<ns5:ReturnCode\>1\</ns5:ReturnCode\>

\<ns5:Error code="140" messageId="040" fatal="true" class="UNKNOWN"\>

\<ns5:Description\>Data validation failed: Please check either the
delimiter, the header row option or the mapping in the CSV
configuration!\</ns5:Description\>

\<ns5:Detail\>It appears when a custom validation rule does not pass.
Data validation failed :
Failure("checkDataSetAttributeValue")\</ns5:Detail\>

\</ns5:Error\>

#### SDMX_CSV specific checks

For type=***<span class="mark">SDMX_CSV</span>*** which means that the
input expected is a SDMX-compatible CSV a configuration parameters file
is needed also and if not provided a similar error will be thrown. For
SDMX_CSV files the start of the file is checked and the very first
element found must be “DATAFLOW” if not the below error will be thrown:

\<ns5:ReturnCode\>1\</ns5:ReturnCode\>

\<ns5:Error code="140" messageId="001" fatal="true" class="UNKNOWN"\>

\<ns5:Description\>No DATAFLOW column found in the
header\</ns5:Description\>

\<ns5:Detail\>The STRUVAL service is not able to process the inputs due
to an internal server error\</ns5:Detail\>

\</ns5:Error\>

No mapping configuration file is needed for SDMX_CSV files.

#### MULTI_LEVEL_CSV, FLR specific checks

For type=***<span class="mark">MULTI_LEVEL_CSV</span>*** as for any type
of the CSV family a parameter file is needed. An additional check for
multilevel files is the number of levels must be above 1, else the
following error will be thrown:

\<ns5:ReturnCode\>-2\</ns5:ReturnCode\>

\<ns5:Error code="500" messageId="001" fatal="true" class="UNKNOWN"\>

\<ns5:Description\>Invalid level number: Please provide a correct level
number!\</ns5:Description\>

\<ns5:Detail\>The STRUVAL service is not able to process the inputs due
to an internal server error\</ns5:Detail\>

Another check that is performed for
***<span class="mark">MULTI_LEVEL_CSV</span>*** files and
***<span class="mark">FLR</span>*** is if a mapping is provided because
is mandatory when reading these type of files.

#### SDMX_ML specific checks

For all types of xml files an initial check is made to validate the xml
syntax and find irregularities. The validation of the input xml file
throws parsing errors:

\<ns5:ReturnCode\>-1\</ns5:ReturnCode\>

\<ns5:Error code="140" messageId="002" fatal="true" class="XML"
line="11" column="22"\>

\<ns5:Description\>ParseError at \[row,col\]:\[11,22\]

Message: Element content can not contain child START_ELEMENT when using
Typed Access methods\</ns5:Description\>

\<ns5:Detail\>The SDMX-ML file is not a well-formed XML file. It may
contain such errors as invalid characters, tags that are not closed or
are closed out of order. Well formedness of an XML file can be checked
using different tools, such as the advanced text editors or
online\</ns5:Detail\>

\</ns5:Error\>

#### Excel specific checks

For excel files additional checks are performed. Firstly checks are
performed to ensure the validation of mapping and parameter sheets
provided for the conversion. For example:

\<ns5:ReturnCode\>-2\</ns5:ReturnCode\>

\<ns5:Error code="500" messageId="001" fatal="true" class="UNKNOWN"\>

\<ns5:Description\>NFGNHDN is not a valid Position
Type\</ns5:Description\>

\<ns5:Detail\>The STRUVAL service is not able to process the inputs due
to an internal server error\</ns5:Detail\>

\</ns5:Error\>

\<ns5:Error code="500" messageId="001" fatal="true" class="UNKNOWN"\>

\<ns5:Description\>The sheet 'sdsdadsa' doesn't exist inside the
workbook of the excel file. Check the mapping sheet and try
again.\</ns5:Description\>

\<ns5:Detail\>The STRUVAL service is not able to process the inputs due
to an internal server error\</ns5:Detail\>

\</ns5:Error\>

### **The** **Asynchronous “ValidateData” method result**

The “ValidateData” method produces an error report as result where each
error has an error code. The error report has two formats and can be
configured by setting the parameter:

**validation.inlineReportFormat**=**true**

in the parameters properties file. The default value is “current” but if
the user could set the parameter with the value:

**validation.inlineReportFormat**=**false**

and the report will have MSD based format. An example with inline
reportFormat is displayed below:

\<SOAP-ENV:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/"
xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"\>  
\<SOAP-ENV:Header/\>  
\<SOAP-ENV:Body\>  
\<ns0:ValidateDataRespMsg
xmlns:ns0="http://xmlns.ec.eu/BusinessActivityService/StruvalBAS/V3"
xmlns:ns2="http://xmlns.ec.eu/BusinessObjects/StruvalDS/V3/"\>  
\<StatusResponse
xmlns:ns5="http://xmlns.ec.eu/BusinessObjects/StruvalDS/StatusReport/V1"\>

\<ns5:Version\>9.8.5\</ns5:Version\>  
\<ns5:Status code="2"\>Validation Completed
Successfully\</ns5:Status\>  
\<ns5:EstimatedTime\>0.345 secs\</ns5:EstimatedTime\>  
\<ns5:RequestId\>b381d089-7fbb-4c63-bab4-49101a7c8799\</ns5:RequestId\>  
\</StatusResponse\>  
\<ReportResponse
xmlns:ns5="http://xmlns.ec.eu/BusinessObjects/StruvalDS/ErrorReport/V1"\>  
\<ns5:ErrorReport errorFound="2" moreErrors="false"\>  
\<ns5:StructureInfo\>  
\<ns5:Id\>EFA_ACC_A_DSD\</ns5:Id\>  
\<ns5:Name\>Integrated evironmental and economic accounting for
forests\</ns5:Name\>  
\<ns5:Agency\>ESTAT\</ns5:Agency\>  
\<ns5:Version\>1.0\</ns5:Version\>  
\<ns5:Dataflow\>  
\<ns5:Id\>EFA_ACC_A\</ns5:Id\>  
\<ns5:Agency\>ESTAT\</ns5:Agency\>  
\<ns5:Version\>1.0\</ns5:Version\>  
\</ns5:Dataflow\>  
\</ns5:StructureInfo\>  
\<ns5:ReturnCode\>2\</ns5:ReturnCode\>  
\<ns5:Error attachedTo="OBS" class="DATA" code="150"
conceptName="OBS_VALUE" conceptType="MEASURE"
conceptValue="'&quot;#VALUE!&quot;'" errorOccurrences="2" fatal="false"
messageId="030"\>  
\<ns5:Description\>Primary Measure OBS_VALUE is reporting invalid value
which should be a floating point number with double precision('Double'),
the decimal part should be separated from the integer part by
"."..\</ns5:Description\>  
\<ns5:Detail\>Appears when reported value of a concept is
unexpected\</ns5:Detail\>  
\<ns5:Data\>  
\<ns5:ErrorDataSource\>  
\<ns5:Dimension\>  
\<ns5:DimensionValue id="REF_AREA" value="FR"/\>  
\<ns5:DimensionValue id="FREQ" value="A"/\>  
\<ns5:DimensionValue id="UNIT" value="MIO_NAC"/\>  
\<ns5:DimensionValue id="INDIC_FO" value="NAP"/\>  
\<ns5:DimensionValue id="STK_FLOW" value="TOTAL"/\>  
\<ns5:DimensionValue id="FOR_ACC" value="B1G"/\>  
\<ns5:DimensionValue id="INDUSE" value="A02"/\>  
\<ns5:DimensionValue id="PROD_WD" value="NAP"/\>  
\<ns5:DimensionValue id="TREESPEC" value="TOTAL"/\>  
\<ns5:DimensionValue id="SOURCE_TABLE" value="B_1"/\>  
\</ns5:Dimension\>  
\<ns5:Position\>  
\<ns5:PositionValue cell="EFA B 1!H34"/\>  
\</ns5:Position\>  
\</ns5:ErrorDataSource\>  
\<ns5:ErrorDataSource\>  
\<ns5:Dimension\>  
\<ns5:DimensionValue id="REF_AREA" value="FR"/\>  
\<ns5:DimensionValue id="FREQ" value="A"/\>  
\<ns5:DimensionValue id="UNIT" value="MIO_NAC"/\>  
\<ns5:DimensionValue id="INDIC_FO" value="NAP"/\>  
\<ns5:DimensionValue id="STK_FLOW" value="TOTAL"/\>  
\<ns5:DimensionValue id="FOR_ACC" value="P11"/\>  
\<ns5:DimensionValue id="INDUSE" value="A02"/\>  
\<ns5:DimensionValue id="PROD_WD" value="NAP"/\>  
\<ns5:DimensionValue id="TREESPEC" value="TOTAL"/\>  
\<ns5:DimensionValue id="SOURCE_TABLE" value="B_2"/\>  
\</ns5:Dimension\>  
\<ns5:Position\>  
\<ns5:PositionValue cell="EFA B 2!K9"/\>  
\</ns5:Position\>  
\</ns5:ErrorDataSource\>  
\</ns5:Data\>  
\</ns5:Error\>  
\</ns5:ErrorReport\>  
\</ReportResponse\>  
\</ns0:ValidateDataRespMsg\>  
\</SOAP-ENV:Body\>  
\</SOAP-ENV:Envelope\>

Let’s discuss the most important elements of the SOAP response to the
validate operation:

<table>
<caption><p>Table 2 – Result of the “validate” method
explained</p></caption>
<colgroup>
<col style="width: 25%" />
<col style="width: 74%" />
</colgroup>
<thead>
<tr>
<th><strong>Xml Response Tag/Attribute</strong></th>
<th><strong>Description</strong></th>
</tr>
</thead>
<tbody>
<tr>
<td><strong>ReturnCode</strong></td>
<td><p>This is the exit code of the validation:</p>
<ul>
<li><p>-2 if there is an error in DSD or associated artefacts (or some
of them are missing)</p></li>
<li><p>-1 if there is a syntax error in the input SDMX-ML
dataset</p></li>
<li><p>0 if the validation is successful and no validation errors were
detected</p></li>
<li><p>&gt;0 if one or more validation errors have been detected (other
than the syntax errors)</p></li>
</ul></td>
</tr>
<tr>
<td><strong>errorsFound</strong></td>
<td>The number of errors found (syntax + structural + data)</td>
</tr>
<tr>
<td><strong>moreErrors</strong></td>
<td><p>This is a hint to the user that more potential errors can occur
after fixing the current ones because the validation algorithm did not
check the whole input (the maxErrorNumber treshold has been reached and
the validation algorithm has been stopped)</p>
<ul>
<li><p>True – if the validation algorithm has been stopped because the
maxErrorNumber (see the input parameters) has been reached.</p></li>
<li><p>False - otherwise</p></li>
</ul></td>
</tr>
<tr>
<td><strong>Error</strong></td>
<td>Error marker tag (see the details below)</td>
</tr>
<tr>
<td><strong>code</strong></td>
<td>The SDMX code of the error</td>
</tr>
<tr>
<td><strong>messageId</strong></td>
<td>A globally unique key for each error, independent of the error
code.</td>
</tr>
<tr>
<td><strong>fatal</strong></td>
<td>True if the error has been fatal and the validation algorithm had to
be stopped because of it</td>
</tr>
<tr>
<td><strong>errorClass</strong></td>
<td><p>This specified the type of error. Possible values are:</p>
<ul>
<li><p>XML – for syntax errors</p></li>
<li><p>SDMX - if the error was a structural error</p></li>
<li><p>DATA – if the error is a data error</p></li>
<li><p>UNKNOWN – For unexpected or internal errors</p></li>
</ul></td>
</tr>
<tr>
<td><strong>line</strong></td>
<td>The column in the input file where the error occured. Applies for
all XML input files and CSV/FLR. The position of the error reported is
that of the level that the error. For example if an error occurred in an
attribute of a series error position is that of the series element.</td>
</tr>
<tr>
<td><strong>column</strong></td>
<td>The column in the input file where the error occured. Applies for
XML input files only. For example if an error occurred in an attribute
of a series, the error position is that of the series’ element. The
column of the element where the error happened is always returned and
not the column of the error’s exact position.</td>
</tr>
<tr>
<td><strong>cell</strong></td>
<td>The cell in the input file where the error occured. Applies to
errors where the input is EXCEL.</td>
</tr>
<tr>
<td><strong>conceptName</strong></td>
<td>the name of Dimension, Attribute, Measure of the single Observation
where the error occurred</td>
</tr>
<tr>
<td><strong>conceptType</strong></td>
<td><p>Possible values are:</p>
<ul>
<li><p>DIMENSION</p></li>
<li><p>ATTRIBUTE</p></li>
<li><p>MEASURE</p></li>
</ul></td>
</tr>
<tr>
<td><strong>conceptValue</strong></td>
<td>the value provided or empty if missing</td>
</tr>
<tr>
<td><strong>errorOccurrences</strong></td>
<td>The number of occurrences of the same error during reading found
until the limit of errors is reached.</td>
</tr>
<tr>
<td><strong>Description</strong></td>
<td>A detailed description of the error</td>
</tr>
<tr>
<td><strong>Detail</strong></td>
<td><p>Approximately one paragraph of static text description:</p>
<p>(1) What has caused this error</p>
<p>(2) What the user should do to fix the error, assuming that the user
can modify dataset and choose a DSD, but has no control over the DSD
content.</p></td>
</tr>
<tr>
<td><strong>Dimension</strong></td>
<td>Each “dimension” holds a dimension ID and its value. The whole set
of dimensions under an error represents the Series or Group key where
the error occurred. Applies to errors where the “errorClass” value is
“DATA”. With the exception when the “attachedTo” value is DATASET since
there is no key at that point.</td>
</tr>
<tr>
<td><strong>attachedTo</strong></td>
<td><p>The Dataset level where error occurred. Applies to errors where
the “errorClass” value is “DATA”. Possible values are:</p>
<ul>
<li><p>DATASET – if the error occurred at DataSet level.</p></li>
<li><p>SERIES – if the error occurred at Series level.</p></li>
<li><p>GROUP - if the error occurred at Group level.</p></li>
<li><p>OBS - if the error occurred at Observation level.</p></li>
</ul></td>
</tr>
</tbody>
</table>

### **A sample request to the asynchronous “ValidateData” of Struval Web Service using SOAPUI tool**

SoapUI is the “de facto” standard in testing web services. The next
paragraphs will show in a step-by-step manner how to create a call to
the “ValidateData” method of the Converter web service. At first a new
project has to be created based on the WSDL of the Converter:

<figure>
<img src="media/image16.png" style="width:5.91749in;height:2.8754in" />
<figcaption><p>Figure 3 - New SoapUI project for Converter Web
Service</p></figcaption>
</figure>

The picture below shows the two bindings created by the SoapUI based on
the provided WSDL, each binding having two methods: convert and
validate.

In this section we will create a request for the “ValidateData” web
service method.

Figure 4 - Converter WS configured in SoapUI

In the sample request created by the SOAP UI, please add three
attachments (one for the DSD, one for the message file and one for the
parameters file). After adding these three parameters, make sure to
match them with the ids provided by SOAP UI as indicated in the picture
below (see selected fields for attachment and the corresponding fields
in Request). If Registry is used to get the structure then only the
input file attachment has to be provided.

Let’s analyze the way StruvalWS implements asynchronous calls.  
The administrator of the WebService has configured a property for a
default timeout for each request. What exactly is this timeout? As soon
as the user executes the request, a countdown starts and when a
predefined timeout comes to an end two things happen:

- If the validation process has finished before the end of this
  countdown then StruvalWS returns immediately the validation results to
  the user. So, in that case the Web Service acts as a synchronous one.

If the validation process has not finished by the end of the countdown,
then a timeout takes place and the StruvalWS returns a response to the
user containing a UUID (unique request id) and a status code

By default, the timeout is set to 1h (3600 seconds). This practically
means that by default the Validation service is running like a
synchronous one. If the user wants to take advantage of the asynchronous
technology, then they have to edit the timeout attribute of ValidateData
element in the SOAP request.

\<v3:ValidateData timeout="10" expiration="172800"\>

*Note that the time is counted in Seconds.*

The example from above means that user is willing to wait up to 10
seconds in order to get their validation results in a synchonous way. If
the validation process has not finished by the timeout of 10 seconds
then the web service will enable the asynchronous mode. It will respond
back to the user with a simple response including one Unique ID for
their request, a status code and a rough estimation.

This practically means that the user will take this ID and then they
will call the getStatus method in order to get their validation results
back.

<img src="media/image17.png" style="width:6.30764in;height:6.99792in" />

The following screenshot demonstrates the case where the user got their
results inside the timeout (like they used to get when the WS was
synchronous).

<img src="media/image18.png" style="width:6.30764in;height:4.46667in"
alt="A screenshot of a computer screen Description automatically generated" />

The following picture demonstrates the case where the result was not
ready by the end of the timeout.

<img src="media/image19.png" style="width:6.30764in;height:2.05139in"
alt="A screen shot of a computer Description automatically generated" />

The user got a status of -300, which means request started, an
estimation time and a request id for usage in the getStatus method.

Then the user can make use of getStatus and get their results back like
in the following picture.

<img src="media/image20.png" style="width:6.792in;height:3.35674in"
alt="A screenshot of a computer Description automatically generated" />

*Note that the validation result is in the respond’s attachment file
because the param.properties file used the MSD report base format.*

<img src="media/image21.png" style="width:5.88624in;height:0.90638in" />

If the property validation.inlineReportFormat was true then the result
would have been in the SOAP response. In the converter-ws.properties
file of Struval web service there is a property called:
*default.validation.cleanup.time=86400*

This is the default time interval in which the clean up mechanism would
be enabled and will delete only the expired requests. With this
implementation, the user can be sure that for as much time as they will
use for the expiration attribute the request will be available on the
server, and untouched by the Janitor (clean up thread).  
Another benefit of the above aproach is that if the server that the web
service is running on is of low specs then the administrator can set a
small default default.validation.cleanup.time so that the web service
does not keep in memory the expired requests.

If the user calls the getStatus with no Id then they get back all the
available requests. See the following picture:

<img src="media/image22.png" style="width:6.30764in;height:1.94375in"
alt="A screenshot of a computer Description automatically generated" />

If properly configured, the request should be sent to the server (by
pressing the triangular play-like button). <u>To attach successfully a
file in the request make sure the Content ID is the same with the cid
that corresponds to each file.</u> See the MTOM example below. The
response should look like the picture below:

For more examples check Annex R – Examples of Validation Requests for
Web Service.

<figure>
<img src="media/image17.png" style="width:6.30764in;height:6.99792in" />
<figcaption><p>Figure 5 - Adding attachments to the "ValidateData"
request</p></figcaption>
</figure>

<figure>
<img src="media/image23.png" style="width:6.30764in;height:5.72014in"
alt="A screenshot of a computer Description automatically generated" />
<figcaption><p>Figure 6 - the SOAP response of the validate
method</p></figcaption>
</figure>

### **A sample request to “ValidateData” using SOAPUI tool with MTOM enabled**

When validating big size files, it is important to have MTOM enabled.

By default, MTOM option is disabled on SOAPUI requests. So, a normal
validate request after having uploaded the test files should look like
this:

<figure>
<img src="media/image24.png" style="width:6.30764in;height:4.14792in" />
<figcaption><p>Figure 7 - the SOAP request of the validate method with
MTOM disabled</p></figcaption>
</figure>

In order to enable MTOM one should apply the following procedure.

1.  Click on the request’s name on the navigator.

2.  Scroll down on the properties panel and search for Enable MTOM and
    Force MTOM options

3.  Change those values from false to true and click on the attachment
    section of the request in order the changes to be applied

Refresh the attachments and the type changes from CONTENT to SWAREF.
Should the user see this in his request, we know “he is on the right
track”.

A representative request of a validation with MTOM enabled is shown on
the screenshot below.only

<figure>
<img src="media/image25.png" style="width:6.01042in;height:5.16973in" />
<figcaption><p>Figure 8 - the SOAP request of the validate method with
MTOM enabled</p></figcaption>
</figure>

When attaching a file the user is obligated to use the same name for
part and contentID (see the highlighted screenshot above).

A good practice when attaching files on the request is to avoid
whitespaces in the filenames. Use the camel case notation instead
(capitalize only the initial letter of each word).

## **Using the “CustomValidateData” method of the Struval web service**

In addition to the checks performed by “ValidateData” method, the
“CustomValidateData” method checks also the custom validation rules. The
custom validation rules specify logical conditions that a dataset must
satisfy in order be considered valid against a custom validation
profile.

A **RuleSet** is a unit for packaging custom validation rules. It is
defined using an XML schema and is stored on the server side in the form
of XML file. Each rule set have a well-known ID that the users can
specify as **RuleSetId** parameter to CustomValidateData method.
Converter Web Service will search the rule set file with the provided ID
and load all the rules along with its dependencies.

### **“CustomValidateData” method parameters**

In this version, the web service only accepts 2 types of data messages:

> • SDMX 2.0 Compact messages
>
> • SDMX 2.1 structure specific messages

As for the structure definition, the web service request accepts only a
DSD (a Dataflow will not be accepted).

<table>
<caption><p>Table 3 - WS “CustomValidateData” input
parameters</p></caption>
<colgroup>
<col style="width: 29%" />
<col style="width: 32%" />
<col style="width: 37%" />
</colgroup>
<thead>
<tr>
<th style="text-align: left;"><strong>Parameter</strong></th>
<th style="text-align: left;"><strong>Type</strong></th>
<th style="text-align: left;"><strong>Description</strong></th>
</tr>
</thead>
<tbody>
<tr>
<td style="text-align: left;"><strong>ValidationInput</strong></td>
<td style="text-align: left;">Byte Array</td>
<td style="text-align: left;"><p>The SDMX message to be validated. This
version of Converter only accepts two types of messages:</p>
<p>• SDMX 2.0 Compact messages</p>
<p>• SDMX 2.1 structure specific messages</p></td>
</tr>
<tr>
<td style="text-align: left;"><strong>ValidationStructure</strong></td>
<td style="text-align: left;">Byte Array</td>
<td style="text-align: left;">the DSD file (A dataflow is not accepted
in this version)</td>
</tr>
<tr>
<td style="text-align: left;"><strong>MaxErrorNumber</strong></td>
<td style="text-align: left;">Integer</td>
<td style="text-align: left;">the max number of errors accepted by the
system before stopping the validation</td>
</tr>
<tr>
<td style="text-align: left;"><strong>RuleSetId</strong></td>
<td style="text-align: left;">String</td>
<td style="text-align: left;"><p>The ID of the rule set used for custom
validation (one of the rulesets existing on the server).</p>
<p>This ID will be matched by the webservice against the filenames
existing under <em><strong>Converter_Data/customvalidation</strong></em>
folder. When a successful match has been found, those validation rules
will be applied to the uploaded input file.</p>
<p>The file extension should not be specified in the ruleSetId
value.</p>
<p>The available rule sets on the server will be disseminated to the end
users by the administrators of the Converter Web Service.</p></td>
</tr>
<tr>
<td
style="text-align: left;"><strong>CsvValidationParameter</strong></td>
<td style="text-align: left;">CsvValidationParameterType</td>
<td style="text-align: left;">Extra parameter if the input is of CSV
type.</td>
</tr>
</tbody>
</table>

\<xs:complexType name=**"CustomValidateDataType"**\>

\<xs:sequence\>

\<xs:element name=**"ValidationInput"**

type=**"xs:base64Binary"** minOccurs=**"0"** /\>

\<xs:element name=**"ValidationStructure"**

type=**"xs:base64Binary"** nillable=**"true"** minOccurs=**"0"** /\>

\<xs:element name=**"MaxErrorNumber"**

type=**"xs:int"**/\>

\<xs:element name=**"RuleSetId"**

type=**"xs:string"** minOccurs=**"0"** /\>

\<xs:element name=**"CsvValidationParameter"**

type=**"tns:CsvValidationParameterType"** minOccurs=**"0"** /\>

\</xs:sequence\>

\</xs:complexType\>

### **“CustomValidateData” method result**

The result of “CustomValidateData” call is the same as the
“ValidateData” call described in section 2.3.2. All the custom
validation errors have errorClass=DATA, so they look like any other data
validation response.

## **Using the “ExplainError” method of the Struval web service**

The “ExplainError” operation is a new addition to the Converter Web
Service. Each error holds a “messageId” unique key and also a “Detail”
element (explained in “**Table 2 – Result of the “ValidateData” method
explained”**). The “ExplainError” method uses the “MessageId” as
parameter. Based on the request, the service returns a list of all the
errors available (“MessageId” key and “detail”), or just a certain
error. “MessageId” and “Detail” are read from a properties file.

The response is a list of XML structures of type:

\<details messageId="{the message id}"\>{text of the detailed
explanation}\</details\>

### **“ExplainError” method parameters**

| **Parameter** | **Type** | **Description** |
|:-----------------|:-----------------|:------------------------------------|
| **messageId** | String | A globally unique key, independent of the error code |

Table 4 - WS “explain” input parameters

\<xs:complexType name=**"ExplainError"**\>

\<xs:sequence\>

\<xs:element name=**"MessageId"**

type=**"xs:String"** /\>

\</xs:sequence\>

\</xs:complexType\>

**“explain” request and response**

There are three possible situations available:

- when “MessageId” is “\*”, the service returns a list of all available
  errors.

\<soapenv:Envelope
xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"

xmlns:web="http://webservice.converter.sdmx.agilis.com/"\>

\<soapenv:Header/\>

\<soapenv:Body\>

\<web:ExplainError\>

\<MessageID\>\*\</MessageID\>

\</web:ExplainError\>

\</soapenv:Body\>

\</soapenv:Envelope\>

<img src="media/image26.png" style="width:5.99166in;height:2.975in" />

Figure 60 - the SOAP response of the explain method when messageID is
“\*”

- when MessageId is of type “001” (an existing key), the operation
  returns a detail element for the given MessageId

\<soapenv:Envelope
xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"

xmlns:web="http://webservice.converter.sdmx.agilis.com/"\>

\<soapenv:Header/\>

\<soapenv:Body\>

\<web:ExplainError\>

\<MessageID\>001\</MessageID\>

\</web:ExplainError\>

\</soapenv:Body\>

\</soapenv:Envelope\>

<figure>
<img src="media/image27.jpg" style="width:5.25834in;height:3.35in"
alt="picture2" />
<figcaption><p>Figure 61 - the SOAP response of the explain method when
messageId is “001”</p></figcaption>
</figure>

- when messageId is different from “\*”/or a key/or the key doesn’t
  exist the response is an empty list. In the below example “050” is a
  messageId that doesn’t exist.

\<soapenv:Envelope
xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"

xmlns:web="http://webservice.converter.sdmx.agilis.com/"\>

\<soapenv:Header/\>

\<soapenv:Body\>

\<web:ExplainError\>

\<MessageId\>050\</MessageId\>

\</web:ExplainError\>

\</soapenv:Body\>

\</soapenv:Envelope\>

<figure>
<img src="media/image28.jpg" style="width:5.99166in;height:2.05in"
alt="picture4" />
<figcaption><p>Figure 62 - the SOAP response of the explain method when
messageId is different from “*”/or key</p></figcaption>
</figure>

## **Using the “GetVersion” method of the Struval web service**

The “GetVersion” method uses the file provided as the only input
parameter to detect the SDMX version and the SDMX format of the file.

### **“GetVersion” method parameters**

| **Parameter** | **Type** | **Description** |
|:-----------------|:-----------------|:------------------------------------|
| **input** | Byte Array | The SDMX file which version and format needs to be detected. |

<figure>
<img src="media/image29.jpg" style="width:4.1in;height:4.675in"
alt="request" />
<figcaption><p>Figure 7 - GetVersion request</p></figcaption>
</figure>

Based on the request above, the response comes back with two pieces of
information: the SDMX version and the SDMX format as in the picture
below:

Figure 8 - GetVersion response

### **The available options for the “version” output parameter** 

| **Value** | **Description**                      |
|:----------|:-------------------------------------|
| **1.0**   | The input file is in SDMX 1.0 format |
| **2.0**   | The input file is SDMX 2.0 format    |
| **2.1**   | The input file is SDMX 2.1 format    |

<img src="media/image30.jpg" style="width:5.99166in;height:2.85in"
alt="Untitled" />Figure 9 - Version output parameter options

### **The available options for the “format” output parameter**

| **Value** | **Description** |
|:------------------------------------|:----------------------------------|
| **COMPACT_SDMX** | The input file is a Compact file |
| **CROSS_SDMX** | The input file is a Cross Sectional file |
| **GENERIC_SDMX** | For Generic files with version 2.0 |
| **GENERIC_DATA_2_1** | For Generic Data files with version 2.1 |
| **GENERIC_TS_DATA_2_1** | For Generic time Series Data files with version 2.1 |
| **STRUCTURE_SPECIFIC_DATA_2_1** | For Structure Specific Data files with version 2.1 |
| **STRUCTURE_SPECIFIC_TS_DATA_2_1** | For Structure Specific Time Series Data files with version 2.1 |
|  |  |
| **UTILITY_SDMX** | For Utility files |
| **MESSAGE_GROUP** | For Message Group files. |

Figure 10 - Format output parameter options

### **Unsupported formats**

In case the user of the web service provides a non SDMX file the web
service will throw an error like in the image below:

<figure>
<img src="media/image31.jpg" style="width:5.85834in;height:2.175in"
alt="error" />
<figcaption><p>Figure 11 - GetVersion error when the input file is not
supported</p></figcaption>
</figure>

## **Using the “GetWsVersion” method of the Struval web service**

The method takes no input parameters.

> The web service method
>
> **GetWsVersion()**
>
> returns a String object that represents the current version of the
> Converter. This is depicted in the following snapshot of the WSDL:
>
> \<message name="GetWsVersion"\>
>
> \<part name="parameters" element="tns:GetWsVersion"/\>
>
> \</message\>
>
> \<message name="GetWsVersionResponse"\>
>
> \<part name="parameters" element="tns:GetWsVersionResponse"/\>
>
> \</message\>
>
> \<portType name="ConverterDS"\>
>
> \<operation name="GetWsVersion"\>
>
> \<input
> wsam:Action="http://xmlns.ec.eu/BusinessActivityService/ConverterBAS/V1/ConverterDS/GetWsVersionRequest"
> message="tns:GetWsVersion"/\>
>
> \<output
> wsam:Action="http://xmlns.ec.eu/BusinessActivityService/ConverterBAS/V1/ConverterDS/GetWsVersionResponse"
> message="tns:GetWsVersionResponse"/\>
>
> \<fault message="tns:Exception" name="Exception"
> wsam:Action="http://xmlns.ec.eu/BusinessActivityService/ConverterBAS/V1/ConverterDS/GetWsVersion/Fault/Exception"/\>
>
> \</operation\>
>
> \</portType\>

## **Using the “GetMetadataMetrics” method of the Metadata metrics web service**

### **“GetMetadataMetrics” method parameters**

<img src="media/image32.png" style="width:6.20683in;height:4.18542in" />

The
[**defaultVersion**](file:///C:/LocalRepositories/deliverables/8.4.5/ValidateData#_)
represents the default version for structure element if there is no
structure version explicitly declared and if the structure file contains
multiple dsds/dataflows inside (see validation) The
*[InputConfig](file:///C:/LocalRepositories/deliverables/8.4.5/ValidateData#_)*
parameters are used for validating non SDMX_ML (see validation).

**MetadataMertrics Web Service** tries to autodetect the type of the
input file. If the type can not be autodetected, an error is thrown:
"The type of the input file can not be autodetected! Add the correct
type of the input file!".

> Table 1 – Parsing input parameters

### **“GetMetadataMetrics” method result**

<img src="media/image33.png" style="width:6.30208in;height:2.35417in" />

Web Service method metadata() will return file metrics and metadata
regarding the input file, such as the size of the file in KB, the number
of observations found in the input file, the file format and the header
of the file as attachment if an SDMX header exists in the input file.

## **Using the “transform” method of the Converter Transformation service**

### **A “transform” method request**

<img src="media/image34.png" style="width:6.30764in;height:5.07153in" />

The request from above has a TransformReqMsg element which consists of
two elements:

- dataFiles: The input files to be converted to another format

- metaFiles: Additional files which are necessary in the conversion

> eg: Data Structure, Mapping, Header, Parameters file

Each datafile should have a cid which matches with the attachment Part
from the attachments section.

In the metaFiles element the user must upload one or more files, that
are required for the Conversion. These files are the following ones and
must be declared in the fileType attribute:

- Parameters

- Structure

- Header

- Mapping

- OutputMapping

- Transcoding

- ExcelMapping

- ExcelParameters

- ExcelTemplate

A sample parameters.properties could be the following:

<img src="media/image35.png" style="width:4.39645in;height:1.36477in" />

In that example the user tries to convert an EXCEL file to a CSV one.
The delimiter of the output file is going to be the \# symbol. The CSV
generated file is not going to have a header row and the Structure used
for the conversion is a simple DSD, not a Dataflow.

The possible options to be specified by the user in the
parameters.properties file are the following ones:

- **input.format:** The format of the input file

- **output.format:** The format of the input file

- **dataFlowAgency:** Agency of the dataflow

- **dataflowId:** Id of the dataflow

- **dataflowVersion:** Version of the dataflow

- **keyFamilyAgency:** Agency of the dsd

- **keyFamilyId:** Id of the dsd

- **keyFamilyVersion:** Version of the dsd

- **specifyDataflow:** If dataflow will be used or not (true or false)

- **useRegistry:** If the registry will be queried for structure or not
  (true or false)

- **registry.url:** Define URL for registry calls

- **registry.type:** Set the type of Registry (SOAP, REST_V1, REST_V2)

- **defaultVersion:** The default version of the structure element if
  version is not defined explicitly

- **csv.input.delimiter:** The delimiter of the input in case of csv
  file

- **csv.output.delimiter**: The delimiter of the output in case of csv
  file

- **csv.unescapeInput:** if set to true the CSV has quotes and they will
  be eliminated.

- **csv.escapeOutput:** if quotes will be used to all values in the
  generated:

  1.  CSV DEFAULT (escape with double quotes only the values that
      contain special characters)

  2.  ESCAPE_ALL (all values have double quotes)

- **csv.level:** The number of the level when input/output is Multi
  level CSV

- **csv.headerRow:** Values that can be used are
  DISREGARD_COLUMN_HEADERS, USE_COLUMN_HEADERS, NO_COLUMN_HEADERS,
  OUT_USE_COLUMN_HEADERS(in a conversion from one FLAT file to another
  FLAT file), OUT_NO_COLUMN_HEADERS(in a conversion from one FLAT file
  to another FLAT file)

- **csv.orderedFlatInput:** In case of flat file the input will be
  ordered or not.

- **input.fieldSeparationCharacter:** The field separation character
  applied on SDMX_CSV_2_0/iSDMX_CSV_2_0, Single Level CSV or FLR input
  files that support SDMX 3.0 features of the files. Must be different
  from the delimiter and the padding character.

- **output.fieldSeparationCharacter:** The field separation character
  applied on SDMX_CSV_2_0/iSDMX_CSV_2_0, Single Level CSV or FLR output
  files that support SDMX 3.0 features of the files. Must be different
  from the delimiter and the padding character.

- **errorIfEmpty:** If the input file is empty or there are not
  observation , then an error is raised

- **flr.padding:** A character that will be used as padding in an flr
  file.

- **dateCompatibility:** In this field the user specifies the date
  format used in the input CSV file. Two formats are available, the SDMX
  format (“-” separated fields, i.e. 2008-09) and the Gesmes format (not
  separated fields, i.e. 200809).

- **gesmes.technique:** Values accepted TIME_RANGE, SINGLE_OBSERVATION

- **generatedFileComment:** Comment for the generated file

- **namespacePrefix:** The output file will contain the namespace values
  added by the user

- **namespaceUri:** the output file will contain the namespaceUri values
  added by the user

- **reportingYearStartDay**: Available only for SDMX 2.1 output formats.
  A string of format “--mm-dd”, containg the month and day the user
  wants to appear in the output file’s REPORTING_YEAR_START_DATE
  attribute in the DataSet

- **headerWriting**: When the value is ‘true’, if the input file is of
  SDMX type, or CSV, or Excel, the response returns the header
  information

- **useXSMeasures**: When set it to true Cross Measures are expected in
  the Structure and in the input data.

- **useExplicitMeasures**: When set it to true explicit Measures are
  expected in the Structure, in the mapped dimensions and in the input
  data. This feature is supported for FLR input files and CSV output
  files.

- **validation.formulaErrors.reported:** When set to true all formula
  errors of an excel input files will be reported. When set to false
  only formula errors which are recognized from Excel will be reported.

- **sdmx_csv.labels**: Accepted values ID, BOTH. If not present ID is
  the default value. When set to BOTH the labels with IDS will be
  written in SDMX_CSV output file. Else only the ID is written in the
  output.

- **sdmx_csv.languages:** Comma delimited list of preferred languages
  (default value is ‘en’) applied only on SDMX_CSV_2_0/iSDMX_CSV_2_0 of
  the output file.

The user must have MTOM enabled to be able to download the generated
file from Converter WS as an actual data file and not in a binary
form.  
<img src="media/image36.png" style="width:6.14669in;height:5.14655in" />

If everything went well the user should get a response like the
following one from Converter Transformation Service.  
<img src="media/image37.png" style="width:6.30764in;height:3.57361in" />

The status should be “SERVICE\_\_OK” and the status code 0.

The attachment can be found at the Attachments section of the SOAP
response. The user has only to export it now by clicking first on the
attachment and then on the export icon like in the screenshot bellow.

<img src="media/image38.png" style="width:6.30764in;height:3.43958in" />

> <span id="_Toc81513626" class="anchor"></span>**Annex A: Structure of
> a multilevel CSV/FLR**

In this section the structure of a CSV/FLR file that is multilevel will
be described.

F

<span id="__RefHeading__440_1278425962"
class="anchor"></span>**Multilevel files**

Flat CSV/FLR files imply that they will contain only one level
information, i.e. Observation level. Thus, all records are equivalent in
terms of structure and semantic. As the sample below all records have
the same number of columns (delimiters) with equivalent semantic (per
column position), where the first column (with value M is the FREQ -
Frequency), the second (values: GR, IT is the REF_AREA (Reference Area),
etc.

M,GR,W,PROD,NS0020,1,2000,200501,1.1,F,A

M,GR,W,PROD,NS0020,1,2000,200502,2.2,F,A

………………………

M,IT,W,PROD,NS0020,1,2000,200501,1.2,F,A

M,IT,W,PROD,NS0020,1,2000,200502,2.5,F,A

The above sample CSV flat file includes all key values (values for all
dimensions, including time), as well as the observed value (i.e. 1.2 and
2.5) and its attached attributes (i.e.F,A).  
  
There are cases though, that a CSV file may contain a multi-level
representation in order to express metadata that concern a set/group of
records. For example:

1,Dataset Attribute1 value,Dataset Attribute2 value

2,GR,W,PROD,NS0020,1,2000,PC,0,2,Elements of the full national

3,M,A,A,P1M

4,200501,1.1,F,A

4,200502,2.2,F,A

4,200503,3.3,F,A

...

3,A,A,A,P1Y

4,2005,123,F,A

4,2006,456,F,A

...

2,GR,W,PROD,NS0021,1,2000,PC,0,2,Elements of the full national

3,M,A,A,P1M

4,200501,1.1,F,A

4,200502,2.2,F,A

4,200503,3.3,F,A

...

3,A,A,A,P1Y

4,2005,123,F,A

4,2006,456,F,A

The prerequisites in the above example are:

- The first column is considered a level identifier, i.e. it defines the
  level of the record.

- The order of records is significant, since each level is considered a
  child of the previously higher level encountered within the CSV file.

- The number of columns (delimiters) per level is equal

- The column semantic per level is equivalent

In this case the key values may be split among the different levels.

<span id="__RefHeading__1071_1307807964" class="anchor"></span>**Sample
multilevel CSV file**

In order to convert from or to a multilevel CSV/FLR file the number of
the levels and the appropriate mapping file should be provided. Also the
argument that defines if the input file is ordered or not should be set
to true. There do not exist any constraints and the conversion to/from
all SDMX formats can be done.

Bellow is presented an example with a conversion from a multilevel file
to a SDMX message. The mapping in Figure 30: Mapping for a multilevel
CSV file is applicable for the following csv file, which describes
demographic data for the year 2005.

1;RQFI05V1;1;A

2;FI;F;ADJT;0;0;P1Y;PERS

3;2005;35;P

1;RQFI05V1;1;M

2;FI;F;DEATHST;0;0;P1Y;PERS

3;2005;23871;P

1;RQFI05V1;1;Q

2;FI;F;LBIRTHST;0;0;P1Y;PERS

3;2005;28345;P

<table>
<colgroup>
<col style="width: 10%" />
<col style="width: 13%" />
<col style="width: 15%" />
<col style="width: 32%" />
<col style="width: 27%" />
</colgroup>
<tbody>
<tr>
<td> </td>
<td><ul>
<li><p><strong>Source file</strong></p></li>
</ul></td>
<td><ul>
<li><p><strong>Output file</strong></p></li>
</ul></td>
<td><ul>
<li><p><strong>Command</strong></p></li>
</ul></td>
<td><ul>
<li><p><strong>Description/Details/Comments</strong></p></li>
</ul></td>
</tr>
<tr>
<td><ul>
<li><p><strong>Example 1</strong></p></li>
</ul></td>
<td> <img src="media/image39.emf" /></td>
<td> <img src="media/image40.wmf" /></td>
<td>converter.bat -header_file "D:\Test Case 8\header.prop" -dsd_file
"D:\Test Case 8\ESTAT+DEMOGRAPHY+2.1.xml" -mapping_file "D:\Test Case
8\30.3_mapping.xml" -ordered_input true -level 3 -delimiter ; "D:\Test
Case 8\IN_CSV.csv" "D:\Test Case 8\OUT_Cross.xml" CSV CROSS_SDMX</td>
<td> A conversion from a CSV multilevel file to a Cross Sectional file
with mapping file “30.3_mapping.xml”, header file “header.prop” and
number of levels=3.</td>
</tr>
</tbody>
</table>

<span id="__RefHeading__225_1286104575" class="anchor"></span>**Sample
CSV file with cross sectional measures that appear in one record**

When converting from a CSV file using a Cross Sectional DSD, the cross
sectional measures that belong to a series might appear in one record
rather than in consecutive rows. The following two file structures might
appear when converting with a cross sectional DSD.

In the first structure each observation value appears along with the
cross sectional measure in one row. Each cross sectional measure appears
in the same row in each record (4th column). This has been defined in
the mapping procedure where the measure dimension is always mapped to
the specific column. In the following sample for the Country Greece (GR)
and for female (F) the annual (A) observation values are reported
consecutively in rows and correspond to Deaths (DEATHST), Emigrants
(EMIGT), Immigrants (IMMIT) and Births (LBIRTHST) respectively.

A;GR;F;DEATHST;2005;23871;P

A;GR;F;EMIGT;2005;6331;P

A;GR;F;IMMIT;2005;10581;P

A;GR;F;LBIRTHST;2005;28345;P

In the second file structure the components that correspond to cross
sectional measures do not appear in the CSV, but only their values.

A;GR;F; 23871; 6331;10581;28345;2005;P

In the above record of the CSV file only the observation values that
correspond to the cross sectional measure appear. Specifically the value
23871 is the measure of Deaths, the value 6331 of Emigrants, the value
of 10581 of Immigrants and the value 28345 of Births. In the mapping
procedure, the user should select to map cross sectional measures
(please see Figure 23: Map cross sectional measures) and map each
measure to a column in the mapping dialog. For this example the measure
DEATHST has been mapped to column 4, the measure EMIGT to column 5, the
measure IMMIT to column 6 and the measure LBIRTHST to column 7. In that
way the user does not have to map the observation value as this will not
appear in a specific column in the CSV file but will appear in the
column that the respective cross sectional measure has been mapped.

> <span id="_APPENDIX_D" class="anchor"></span>**Annex B: Examples of
> Excel to SDMX conversion**

In this section few examples related to Excel to SDMX conversion are
described.

To use a mapping between data sheets and parameter sheets of an Excel
file there are several ways. You can provide (in web service and cli) an
external file that will look like *MappingXlsParameters.txt,* and
matches the names of the data sheets and the names of the parameters
sheets, you can attach a sheet inside excel file with the name
*Parameter_mapping* (see Fig.1), or you can attach a parameters mapping
sheet inside the external excel file that contains only Parameters
sheets and mapping sheet. With the parameter mapping sheet you can
provide different parameter sheet for the same Data Sheet. The parameter
mapping sheet must contain on the first row the column headers. If a
parameter mapping is provided then converter no longer ignores hidden
sheets if any, all data sheets that are present in the mapping will be
converted.

<img src="media/image41.jpg" style="width:6.05208in;height:3.60417in"
alt="Untitled-1" />

**Fig. 1**

The attached 0101QY.xlsx will be used with input format Excel. It has
two data sheets 0101 QY V and 0101 QY L and only one parameter sheet. In
this case there will be no need for an external parameter file and also
no mapping parameter is needed as the existing parameter sheet will be
used to process all data sheets. But if an external parameter and
mapping file is provided then the external file will be used.

![](media/image42.emf)

ExcelData.xlsx has two data sheets and two parameter sheets.

If no mapping and no external parameter file is provided then the first
parameter sheet – Parameter_Data1 is used. If an external parameter file
(e.g. the attached *paramsExternal.xlsx*) is given, but no mapping, then
the external parameter file is used.

If a mapping between data sheets and parameter sheets is provided then
the parameter sheets are used according to the mapping. In
*MappingXlsParameters.txt* Data1 will be processed using description
from Parameters_Data1 and Data2 with Parameters_Data2.

If no mapping and no external parameter file is provided then the first
parameter sheet (in our example Parameter_Data1) is used. If an external
parameter file is given (e.g. the attached *paramsExternal.xlsx*) which
contains parameter sheets and a mapping then the external file is used.
If the external file is given but it contains only a mapping file then
the mapping from the external file is used and searches for the
parameter sheets inside the excel. If the external parameter file
contains only parameter sheet and no mapping then we search inside the
excel input file for a mapping that uses the parameter sheets from the
external file.

![](media/image43.emf) ![](media/image44.emf) ![](media/image45.emf)

*In general the following priority is used for the mapping of the
parameter sheets:*

**1<sup>st</sup> (the highest priority):** read the mapping from
external file or UI (mutually exclusive) even if a parameter mapping
sheet exists inside excel the mapping from the external file will be
used.  
**2<sup>nd</sup>:** read the mapping from excel (sheet with the name
*Parameter_mapping*).  
**3<sup>rd</sup> (the lowest priority):** default mapping (the first
Parameter sheet will be used for all non-"val" sheets).

> <span id="_APPENDIX_E_–" class="anchor"></span>**Annex C: How Excel
> handles decimal numbers**

<span id="_Toc431229414" class="anchor"></span>**Excel adheres to the
IEEE 754 standard**

> This means that Excel is not always accurate when performing floating
> point computations (see
> [<u>this</u>](http://support.microsoft.com/kb/78113) link from
> Microsoft).

<span id="_Toc431229415" class="anchor"></span>**What Excel displays is
NOT what is stored internally**

> Excel stores numbers differently that you may have them formatted on
> the worksheet. Under normal circumstances, Excel stores numeric values
> as "Double Precision Floating Point" numbers, or "Doubles" for short.
> These are 8-byte variables that can store numbers accurate to
> approximately 15 decimal places. You may have only two decimal places
> displayed on the worksheet, but the underlying value has the full 15
> decimal places. (Paragraph taken from
> [<u>here</u>](http://www.cpearson.com/excel/rounding.htm))
>
> When a certain value is obtained as the computation of several other
> cells, due to the floating point arithmetic (see point 1), Excel
> displays rounded values of what it stores internally. If you export
> the worksheet to Office 2003 XML format, you will see the real value
> stored.
>
> Example: Make the following computation in Excel: 4.1 – 4 and
> copy-paste the result into another worksheet The result will be shown
> in the formula bar as 0.099999999999 but the cell will contain the
> value 0.1
>
> Any API reading excel will have access to the internal stored value
> that’s why we have to apply a rounding algorithm when reading values
> from Excel.
>
> <span id="_APPENDIX_F_–" class="anchor"></span>**Annex D: The rounding
> mechanism implemented in Converter**

As we’ve seen in [<u>Appendix E</u>](#_APPENDIX_E_–), Excel uses the
IEEE 754 standard for handling decimal number arithmetic. Due to this
standard, for some computations, Excel uses internally approximations of
the mathematical results (i.e. for a simple operation like 4.1 - 4 Excel
stores internally the result 0.0999999999994). Knowing that this
approximation is not at all user-friendly, Excel performs a rounding
algorithm to improve the displaying of Numbers (i.e. as expected for the
formula 4.1 - 4 the displayed result is 0.1 and this is because of the
rounding not due to the correct mathematical computation).

Since Excel exports to any API (including the JAVA APIs) the internal
stored values (i.e. the approximations) instead of the displayed values
(the rounded ones), SDMX Converter is forced to use a rounding mechanism
itself in order to display the same numbers as those shown inside Excel.
Tests have shown that the HALF_EVEN algorithm provides the best results.

[<u>HALF_EVEN</u>](http://docs.oracle.com/javase/7/docs/api/java/math/RoundingMode.html#HALF_EVEN)
is the rounding mode to round towards the "nearest neighbour" unless
both neighbours are equidistant, in which case, round towards the even
neighbour. It behaves as for
[<u>HALF_UP</u>](http://docs.oracle.com/javase/7/docs/api/java/math/RoundingMode.html#HALF_UP)
if the digit to the left of the discarded fraction is odd and it behaves
as for
[<u>HALF_DOWN</u>](http://docs.oracle.com/javase/7/docs/api/java/math/RoundingMode.html#HALF_DOWN)
if it's even.

This is the rounding mode that statistically minimizes cumulative error
when applied repeatedly over a sequence of calculations. It is sometimes
known as "Banker's rounding," and is chiefly used in the USA. This
rounding mode is analogous to the rounding policy used for float and
double arithmetic in Java.

Some rounding examples:

<table>
<colgroup>
<col style="width: 23%" />
<col style="width: 25%" />
<col style="width: 27%" />
<col style="width: 23%" />
</colgroup>
<thead>
<tr>
<th style="text-align: center;"><strong>Excel</strong></th>
<th colspan="3"
style="text-align: center;"><strong>Converter</strong></th>
</tr>
</thead>
<tbody>
<tr>
<td>Number as provided by Excel</td>
<td>Converted using default rounding precision (= 6)</td>
<td>Converted using rounding precision 0</td>
<td>Converted using rounding precision 15</td>
</tr>
<tr>
<td style="text-align: right;">1.2</td>
<td style="text-align: right;">1.2</td>
<td style="text-align: right;">1</td>
<td style="text-align: right;">1.2</td>
</tr>
<tr>
<td style="text-align: right;">1.49</td>
<td style="text-align: right;">1.49</td>
<td style="text-align: right;">1</td>
<td style="text-align: right;">1.49</td>
</tr>
<tr>
<td style="text-align: right;">1.5</td>
<td style="text-align: right;">1.5</td>
<td style="text-align: right;">2</td>
<td style="text-align: right;">1.5</td>
</tr>
<tr>
<td style="text-align: right;">577658.06999999995</td>
<td style="text-align: right;">577658.07</td>
<td style="text-align: right;">577658</td>
<td style="text-align: right;">577658.06999999995</td>
</tr>
</tbody>
</table>

As shown in the table above, if user sets the precision too high,
converter will display the values as they come from Excel (i.e. if the
user sets the precision to 15 then we cannot hide the 0.999-like values
which we are trying to avoid through this rounding).

> <span id="_Toc431229417" class="anchor"></span>**Annex E – CSV
> Input/Output escaping mechanism**

For CSV Input:

CSV values with quotes, e.g "2010":

- If ‘Has Double Quotes’ is selected (in the GUI or Webapp applications
  ) or ‘UnescapeCSVInput’ (in Web Service or CLI applications) set to
  true, it means the CSV has quotes and they will be eliminated.
  Therefore the output will be 2010.

- If ‘Has Double Quotes’ is not selected (in the GUI or Webapp
  applications ) or ‘UnescapeCSVInput’ (in Web Service or CLI
  applications) set to false, it means the CSV has quotes but the user
  says there are no quotes, therefore an Exception will be thrown,
  warning the user about this discrepancy: "If the CSV values have
  quotes, please check 'Has double quotes' or set 'UnescapeCSVInput' to
  true".

CSV values without quotes, e.g 2010 :

- If ‘Has Double Quotes’ is selected (in the GUI or Webapp applications
  ) or ‘UnescapeCSVInput’ (in Web Service or CLI applications) set to
  true, an exception will be thrown warning the user that the CSV values
  do not include any quotes: "If the CSV values does not have quotes,
  please uncheck 'Has double quotes' or set 'UnescapeCSVInput' to
  false".

- If ‘Has Double Quotes’ is not selected (in the GUI or Webapp
  applications ) or ‘UnescapeCSVInput’ (in Web Service or CLI
  applications) set to false, it means the csv input is expected not to
  have quotes and the values will just be passed to the output. In this
  case, the output will contain the value: 2010.

For CSV Output:

- If ‘Use Double Quotes’ (in the GUI or Webapp applications) is set to
  “Only when needed” then when a value contains a special character then
  the value is exported with double quotes. When is set to “Use double
  quotes” then all values will have double quotes.

- For Web Service and client application we use the parameter
  EscapeCSVOutput, which can be set with the following values:

1.  DEFAULT (escape with double quotes only the values that contain
    special characters)

2.  ESCAPE_ALL (all values have double quotes)

> From v8.3.0 of Converter and on whenever ESCAPE_NONE is used as an
> option for EscapeCSVOutput parameter, Converter would automatically
> translate this to DEFAULT for backwards compatibility reasons.
>
> <span id="_Ref431216025" class="anchor"></span>**Annex F – Converter
> Web Service and Struval Web Service WSDLs**

1.  <span id="_Toc159321875" class="anchor"></span>**Converter Web
    Service:**

> *\<?*xml version="1.0" encoding="UTF-8"*?\>  *
> \<wsdl:definitions name="ConverterDS"  
> targetNamespace="http://xmlns.ec.eu/BusinessActivityService/ConverterBAS/V2"  
> xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"  
> xmlns:wsaw="http://www.w3.org/2006/05/addressing/wsdl"  
> xmlns:tns="http://xmlns.ec.eu/BusinessActivityService/ConverterBAS/V2"  
> xmlns:ns1="http://xmlns.ec.eu/BusinessObjects/ConverterDS/V2/"  
> xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"  
> xmlns:wsam="http://www.w3.org/2007/05/addressing/metadata"\>  
> \<wsdl:types\>  
> \<schema xmlns="http://www.w3.org/2001/XMLSchema"\>  
> \<import
> namespace="http://xmlns.ec.eu/BusinessObjects/ConverterDS/V2/"  
> schemaLocation="ConverterWebService_schema1.xsd"/\>  
> \<import
> namespace="http://xmlns.ec.eu/BusinessObjects/ConverterDS/V2/"  
> schemaLocation="ConverterWebService_schema2.xsd"/\>  
> \</schema\>  
> \</wsdl:types\>  
> \<wsdl:message name="GetWsVersionResponse"\>  
> \<wsdl:part name="parameters" element="tns:GetWsVersionResponse"\>  
> \</wsdl:part\>  
> \</wsdl:message\>  
> \<wsdl:message name="Exception"\>  
> \<wsdl:part name="Exception" element="tns:Exception"\>  
> \</wsdl:part\>  
> \</wsdl:message\>  
> \<wsdl:message name="ConvertDataResponse"\>  
> \<wsdl:part name="parameters" element="ns1:ConvertDataRespMsg"\>  
> \</wsdl:part\>  
> \</wsdl:message\>  
> \<wsdl:message name="ConvertData"\>  
> \<wsdl:part name="parameters" element="ns1:ConvertData"\>  
> \</wsdl:part\>  
> \</wsdl:message\>  
> \<wsdl:message name="GetWsVersion"\>  
> \<wsdl:part name="parameters" element="tns:GetWsVersion"\>  
> \</wsdl:part\>  
> \</wsdl:message\>  
> \<wsdl:message name="GetStatus"\>  
> \<wsdl:part name="parameters" element="tns:GetStatus"\>  
> \</wsdl:part\>  
> \</wsdl:message\>  
> \<wsdl:portType name="ConverterDS"\>  
> \<wsdl:operation name="ConvertData"\>  
> \<wsdl:input name="ConvertData" message="tns:ConvertData"  
> wsam:Action="http://xmlns.ec.eu/BusinessObjects/ConverterDS/V2/ConvertDataReqMsg"  
> wsaw:Action="http://xmlns.ec.eu/BusinessObjects/ConverterDS/V2/ConvertDataReqMsg"\>  
> \</wsdl:input\>  
> \<wsdl:output name="ConvertDataResponse"
> message="tns:ConvertDataResponse"  
> wsam:Action="http://xmlns.ec.eu/BusinessObjects/ConverterDS/V2/ConvertDataRespMsg"  
> wsaw:Action="http://xmlns.ec.eu/BusinessObjects/ConverterDS/V2/ConvertDataRespMsg"\>  
> \</wsdl:output\>  
> \<wsdl:fault name="Exception" message="tns:Exception"  
> wsam:Action="http://xmlns.ec.eu/BusinessObjects/ConverterDS/V2/Exception"  
> wsaw:Action="http://xmlns.ec.eu/BusinessObjects/ConverterDS/V2/Exception"\>  
> \</wsdl:fault\>  
> \</wsdl:operation\>  
> \<wsdl:operation name="GetWsVersion"\>  
> \<wsdl:input name="GetWsVersion" message="tns:GetWsVersion"\>  
> \</wsdl:input\>  
> \<wsdl:output name="GetWsVersionResponse"
> message="tns:GetWsVersionResponse"\>  
> \</wsdl:output\>  
> \<wsdl:fault name="Exception" message="tns:Exception"\>  
> \</wsdl:fault\>  
> \</wsdl:operation\>  
> \<wsdl:operation name="GetStatus"\>  
> \<wsdl:input name="GetStatus" message="tns:GetStatus"\>  
> \</wsdl:input\>  
> \<wsdl:output name="ConvertDataResponse"
> message="tns:ConvertDataResponse"  
> wsam:Action="http://xmlns.ec.eu/BusinessObjects/ConverterDS/V2/ConvertDataRespMsg"  
> wsaw:Action="http://xmlns.ec.eu/BusinessObjects/ConverterDS/V2/ConvertDataRespMsg"\>  
> \</wsdl:output\>  
> \<wsdl:fault name="Exception" message="tns:Exception"\>  
> \</wsdl:fault\>  
> \</wsdl:operation\>  
> \</wsdl:portType\>  
> \<wsdl:binding name="ConverterDSServiceBinding"
> type="tns:ConverterDS"\>  
> \<soap:binding style="document"
> transport="http://schemas.xmlsoap.org/soap/http"/\>  
> \<wsdl:operation name="ConvertData"\>  
> \<soap:operation
> soapAction="http://xmlns.ec.eu/BusinessObjects/ConverterDS/V2/ConvertDataReqMsg"
> style="document"/\>  
> \<wsdl:input name="ConvertData"\>  
> \<soap:body use="literal"/\>  
> \</wsdl:input\>  
> \<wsdl:output name="ConvertDataResponse"\>  
> \<soap:body use="literal"/\>  
> \</wsdl:output\>  
> \<wsdl:fault name="Exception"\>  
> \<soap:fault name="Exception" use="literal"/\>  
> \</wsdl:fault\>  
> \</wsdl:operation\>  
> \<wsdl:operation name="GetWsVersion"\>  
> \<soap:operation soapAction="" style="document"/\>  
> \<wsdl:input name="GetWsVersion"\>  
> \<soap:body use="literal"/\>  
> \</wsdl:input\>  
> \<wsdl:output name="GetWsVersionResponse"\>  
> \<soap:body use="literal"/\>  
> \</wsdl:output\>  
> \<wsdl:fault name="Exception"\>  
> \<soap:fault name="Exception" use="literal"/\>  
> \</wsdl:fault\>  
> \</wsdl:operation\>  
> \<wsdl:operation name="GetStatus"\>  
> \<soap:operation soapAction="" style="document"/\>  
> \<wsdl:input name="GetStatus"\>  
> \<soap:body use="literal"/\>  
> \</wsdl:input\>  
> \<wsdl:output name="ConvertDataResponse"\>  
> \<soap:body use="literal"/\>  
> \</wsdl:output\>  
> \<wsdl:fault name="Exception"\>  
> \<soap:fault name="Exception" use="literal"/\>  
> \</wsdl:fault\>  
> \</wsdl:operation\>  
> \</wsdl:binding\>  
> \<wsdl:service name="ConverterDS"\>  
> \<wsdl:port name="ConverterDSService"
> binding="tns:ConverterDSServiceBinding"\>  
> \<soap:address
> location="http://localhost:8080/converter_war/ConverterWebService"/\>  
> \</wsdl:port\>  
> \</wsdl:service\>  
> \</wsdl:definitions\>

1.  <span id="_Toc46407922" class="anchor"></span>**Struval Web
    Service:**

> *\<?*xml version="1.0" encoding="UTF-8"*?\>  *
> \<wsdl:definitions name="StruvalWebServiceService"  
> targetNamespace="http://xmlns.ec.eu/BusinessActivityService/StruvalBAS/V3"  
> xmlns:wsaw="http://www.w3.org/2006/05/addressing/wsdl"
> xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"  
> xmlns:tns="http://xmlns.ec.eu/BusinessActivityService/StruvalBAS/V3"  
> xmlns:xsd="http://www.w3.org/2001/XMLSchema"
> xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"  
> xmlns:wsam="http://www.w3.org/2007/05/addressing/metadata"  
> xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
> xsi:schemaLocation="http://www.w3.org/2007/05/addressing/metadata
> http://www.w3.org/2007/05/addressing/metadata"\>  
> \<wsdl:types\>  
> \<schema xmlns="http://www.w3.org/2001/XMLSchema"\>  
> \<import
> namespace="http://xmlns.ec.eu/BusinessActivityService/StruvalBAS/V3"  
> schemaLocation="StruvalWebService_schema3.xsd"/\>  
> \</schema\>  
> \</wsdl:types\>  
> \<wsdl:message name="ExplainErrorResponse"\>  
> \<wsdl:part name="parameters" element="tns:ExplainErrorRespMsg"\>  
> \</wsdl:part\>  
> \</wsdl:message\>  
> \<wsdl:message name="Exception"\>  
> \<wsdl:part name="Exception" element="tns:Exception"\>  
> \</wsdl:part\>  
> \</wsdl:message\>  
> \<wsdl:message name="ValidateDataResponse"\>  
> \<wsdl:part name="parameters" element="tns:ValidateDataRespMsg"\>  
> \</wsdl:part\>  
> \</wsdl:message\>  
> \<wsdl:message name="ExplainError"\>  
> \<wsdl:part name="parameters" element="tns:ExplainError"\>  
> \</wsdl:part\>  
> \</wsdl:message\>  
> \<wsdl:message name="GetWsVersionResponse"\>  
> \<wsdl:part name="parameters" element="tns:GetWsVersionResponse"\>  
> \</wsdl:part\>  
> \</wsdl:message\>  
> \<wsdl:message name="GetStatusResponse"\>  
> \<wsdl:part name="parameters" element="tns:ValidateDataRespMsg"\>  
> \</wsdl:part\>  
> \</wsdl:message\>  
> \<wsdl:message name="GetVersionResponse"\>  
> \<wsdl:part name="parameters" element="tns:GetVersionRespMsg"\>  
> \</wsdl:part\>  
> \</wsdl:message\>  
> \<wsdl:message name="ValidateData"\>  
> \<wsdl:part name="parameters" element="tns:ValidateData"\>  
> \</wsdl:part\>  
> \</wsdl:message\>  
> \<wsdl:message name="GetWsVersion"\>  
> \<wsdl:part name="parameters" element="tns:GetWsVersion"\>  
> \</wsdl:part\>  
> \</wsdl:message\>  
> \<wsdl:message name="GetStatus"\>  
> \<wsdl:part name="parameters" element="tns:GetStatus"\>  
> \</wsdl:part\>  
> \</wsdl:message\>  
> \<wsdl:message name="GetVersion"\>  
> \<wsdl:part name="parameters" element="tns:GetVersion"\>  
> \</wsdl:part\>  
> \</wsdl:message\>  
> \<wsdl:portType name="StruvalDS"\>  
> \<wsdl:operation name="ExplainError"\>  
> \<wsdl:input name="ExplainError" message="tns:ExplainError"  
> wsam:Action="http://xmlns.ec.eu/BusinessActivityService/StruvalBAS/V3/ExplainErrorReqMsg"  
> wsaw:Action="http://xmlns.ec.eu/BusinessActivityService/StruvalBAS/V3/ExplainErrorReqMsg"\>  
> \</wsdl:input\>  
> \<wsdl:output name="ExplainErrorResponse"
> message="tns:ExplainErrorResponse"  
> wsam:Action="http://xmlns.ec.eu/BusinessActivityService/StruvalBAS/V3/ExplainErrorRespMsg"  
> wsaw:Action="http://xmlns.ec.eu/BusinessActivityService/StruvalBAS/V3/ExplainErrorRespMsg"\>  
> \</wsdl:output\>  
> \<wsdl:fault name="Exception" message="tns:Exception"  
> wsam:Action="http://xmlns.ec.eu/BusinessActivityService/StruvalBAS/V3/Exception"  
> wsaw:Action="http://xmlns.ec.eu/BusinessActivityService/StruvalBAS/V3/Exception"\>  
> \</wsdl:fault\>  
> \</wsdl:operation\>  
> \<wsdl:operation name="ValidateData"\>  
> \<wsdl:input name="ValidateData" message="tns:ValidateData"  
> wsam:Action="http://xmlns.ec.eu/BusinessActivityService/StruvalBAS/V3/ValidateDataReqMsg"  
> wsaw:Action="http://xmlns.ec.eu/BusinessActivityService/StruvalBAS/V3/ValidateDataReqMsg"\>  
> \</wsdl:input\>  
> \<wsdl:output name="ValidateDataResponse"
> message="tns:ValidateDataResponse"  
> wsam:Action="http://xmlns.ec.eu/BusinessActivityService/StruvalBAS/V3/ValidateDataRespMsg"  
> wsaw:Action="http://xmlns.ec.eu/BusinessActivityService/StruvalBAS/V3/ValidateDataRespMsg"\>  
> \</wsdl:output\>  
> \<wsdl:fault name="Exception" message="tns:Exception"  
> wsam:Action="http://xmlns.ec.eu/BusinessActivityService/StruvalBAS/V3/Exception"  
> wsaw:Action="http://xmlns.ec.eu/BusinessActivityService/StruvalBAS/V3/Exception"\>  
> \</wsdl:fault\>  
> \</wsdl:operation\>  
> \<wsdl:operation name="GetVersion"\>  
> \<wsdl:input name="GetVersion" message="tns:GetVersion"  
> wsam:Action="http://xmlns.ec.eu/BusinessActivityService/StruvalBAS/V3/GetVersionReqMsg"  
> wsaw:Action="http://xmlns.ec.eu/BusinessActivityService/StruvalBAS/V3/GetVersionReqMsg"\>  
> \</wsdl:input\>  
> \<wsdl:output name="GetVersionResponse"
> message="tns:GetVersionResponse"  
> wsam:Action="http://xmlns.ec.eu/BusinessActivityService/StruvalBAS/V3/GetVersionRespMsg"  
> wsaw:Action="http://xmlns.ec.eu/BusinessActivityService/StruvalBAS/V3/GetVersionRespMsg"\>  
> \</wsdl:output\>  
> \<wsdl:fault name="Exception" message="tns:Exception"  
> wsam:Action="http://xmlns.ec.eu/BusinessActivityService/StruvalBAS/V3/Exception"  
> wsaw:Action="http://xmlns.ec.eu/BusinessActivityService/StruvalBAS/V3/Exception"\>  
> \</wsdl:fault\>  
> \</wsdl:operation\>  
> \<wsdl:operation name="GetWsVersion"\>  
> \<wsdl:input name="GetWsVersion" message="tns:GetWsVersion"\>  
> \</wsdl:input\>  
> \<wsdl:output name="GetWsVersionResponse"
> message="tns:GetWsVersionResponse"\>  
> \</wsdl:output\>  
> \<wsdl:fault name="Exception" message="tns:Exception"\>  
> \</wsdl:fault\>  
> \</wsdl:operation\>  
> \<wsdl:operation name="GetStatus"\>  
> \<wsdl:input name="GetStatus" message="tns:GetStatus"\>  
> \</wsdl:input\>  
> \<wsdl:output name="GetStatusResponse"
> message="tns:GetStatusResponse"\>  
> \</wsdl:output\>  
> \<wsdl:fault name="Exception" message="tns:Exception"\>  
> \</wsdl:fault\>  
> \</wsdl:operation\>  
> \</wsdl:portType\>  
> \<wsdl:binding name="StruvalWebServiceServiceSoapBinding"
> type="tns:StruvalDS"\>  
> \<soap:binding style="document"
> transport="http://schemas.xmlsoap.org/soap/http"/\>  
> \<wsdl:operation name="ExplainError"\>  
> \<soap:operation
> soapAction="http://xmlns.ec.eu/BusinessActivityService/StruvalBAS/V3/ExplainErrorReqMsg"  
> style="document"/\>  
> \<wsdl:input name="ExplainError"\>  
> \<soap:body use="literal"/\>  
> \</wsdl:input\>  
> \<wsdl:output name="ExplainErrorResponse"\>  
> \<soap:body use="literal"/\>  
> \</wsdl:output\>  
> \<wsdl:fault name="Exception"\>  
> \<soap:fault name="Exception" use="literal"/\>  
> \</wsdl:fault\>  
> \</wsdl:operation\>  
> \<wsdl:operation name="ValidateData"\>  
> \<soap:operation
> soapAction="http://xmlns.ec.eu/BusinessActivityService/StruvalBAS/V3/ValidateDataReqMsg"  
> style="document"/\>  
> \<wsdl:input name="ValidateData"\>  
> \<soap:body use="literal"/\>  
> \</wsdl:input\>  
> \<wsdl:output name="ValidateDataResponse"\>  
> \<soap:body use="literal"/\>  
> \</wsdl:output\>  
> \<wsdl:fault name="Exception"\>  
> \<soap:fault name="Exception" use="literal"/\>  
> \</wsdl:fault\>  
> \</wsdl:operation\>  
> \<wsdl:operation name="GetVersion"\>  
> \<soap:operation
> soapAction="http://xmlns.ec.eu/BusinessActivityService/StruvalBAS/V3/GetVersionReqMsg"  
> style="document"/\>  
> \<wsdl:input name="GetVersion"\>  
> \<soap:body use="literal"/\>  
> \</wsdl:input\>  
> \<wsdl:output name="GetVersionResponse"\>  
> \<soap:body use="literal"/\>  
> \</wsdl:output\>  
> \<wsdl:fault name="Exception"\>  
> \<soap:fault name="Exception" use="literal"/\>  
> \</wsdl:fault\>  
> \</wsdl:operation\>  
> \<wsdl:operation name="GetWsVersion"\>  
> \<soap:operation soapAction="" style="document"/\>  
> \<wsdl:input name="GetWsVersion"\>  
> \<soap:body use="literal"/\>  
> \</wsdl:input\>  
> \<wsdl:output name="GetWsVersionResponse"\>  
> \<soap:body use="literal"/\>  
> \</wsdl:output\>  
> \<wsdl:fault name="Exception"\>  
> \<soap:fault name="Exception" use="literal"/\>  
> \</wsdl:fault\>  
> \</wsdl:operation\>  
> \<wsdl:operation name="GetStatus"\>  
> \<soap:operation soapAction="" style="document"/\>  
> \<wsdl:input name="GetStatus"\>  
> \<soap:body use="literal"/\>  
> \</wsdl:input\>  
> \<wsdl:output name="GetStatusResponse"\>  
> \<soap:body use="literal"/\>  
> \</wsdl:output\>  
> \<wsdl:fault name="Exception"\>  
> \<soap:fault name="Exception" use="literal"/\>  
> \</wsdl:fault\>  
> \</wsdl:operation\>  
> \</wsdl:binding\>  
> \<wsdl:service name="StruvalWebService"\>  
> \<wsdl:port name="StruvalDSService"
> binding="tns:StruvalWebServiceServiceSoapBinding"\>  
> \<soap:address location="http://localhost:9090/StruvalWebService"/\>  
> \</wsdl:port\>  
> \</wsdl:service\>  
> \</wsdl:definitions\>

<span id="_Toc30505114" class="anchor"></span>**Metadata Metrics**

![](media/image46.emf)

<span id="_Toc81513640" class="anchor"></span>**Converter Transformation
Service**

*  *
\<WL5G3N2:definitions xmlns=""
xmlns:WL5G3N0="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd"
xmlns:WL5G3N1="http://www.w3.org/ns/ws-policy"
xmlns:WL5G3N2="http://schemas.xmlsoap.org/wsdl/"
xmlns:WL5G3N3="http://xmlns.ec.eu/DataService/Core/TransformationService/V2/"
xmlns:WL5G3N4="http://schemas.xmlsoap.org/wsdl/soap/"
xmlns:wsp="http://schemas.xmlsoap.org/ws/2004/09/policy"
name="TransformationService"
targetNamespace="http://xmlns.ec.eu/DataService/Core/TransformationService/V2/"\>  
\<wsp:UsingPolicy WL5G3N2:Required="true"/\>  
\<wsp:Policy WL5G3N0:Id="Mtom.xml"\>  
\<wsoma:OptimizedMimeSerialization
xmlns:wsoma="http://schemas.xmlsoap.org/ws/2004/09/policy/optimizedmimeserialization"/\>  
\</wsp:Policy\>  
\<WL5G3N1:Policy
WL5G3N0:Id="TransformationStreamingPortBinding_MTOM_Policy-TransformationStreamingPortBinding_MTOM_Policy"\>  
\<wsoma:OptimizedMimeSerialization
xmlns:wsoma="http://schemas.xmlsoap.org/ws/2004/09/policy/optimizedmimeserialization"/\>  
\</WL5G3N1:Policy\>  
\<WL5G3N2:types\>  
\<xsd:schema
xmlns:WL5G3N0="http://schemas.xmlsoap.org/ws/2004/09/policy"
xmlns:WL5G3N1="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd"
xmlns:WL5G3N2="http://www.w3.org/ns/ws-policy"
xmlns:WL5G3N3="http://schemas.xmlsoap.org/wsdl/"
xmlns:WL5G3N4="http://xmlns.ec.eu/DataService/Core/TransformationService/V2/"
xmlns:WL5G3N5="http://schemas.xmlsoap.org/wsdl/soap/"
xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"
xmlns:tns="http://xmlns.ec.eu/DataService/Core/TransformationService/V2/"
xmlns:wsam="http://www.w3.org/2007/05/addressing/metadata"
xmlns:wsp="http://www.w3.org/ns/ws-policy"
xmlns:wsp1_2="http://schemas.xmlsoap.org/ws/2004/09/policy"
xmlns:wssutil="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd"
xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd"
xmlns:xsd="http://www.w3.org/2001/XMLSchema"\>  
\<xsd:import
namespace="http://xmlns.ec.eu/DataService/Core/TransformationService/V2/"
schemaLocation="http://localhost:8080/converter_ws/ConverterHTI?xsd=5"/\>  
\</xsd:schema\>  
\</WL5G3N2:types\>  
\<WL5G3N2:message name="TransformReqMsgType"\>  
\<WL5G3N2:part element="WL5G3N3:TransformReqMsgType"
name="parameters"/\>  
\</WL5G3N2:message\>  
\<WL5G3N2:message name="TransformRespMsgType"\>  
\<WL5G3N2:part element="WL5G3N3:TransformRespMsgType"
name="parameters"/\>  
\</WL5G3N2:message\>  
\<WL5G3N2:portType name="TransformationService"\>  
\<WL5G3N2:operation name="transform"\>  
\<WL5G3N2:input message="WL5G3N3:TransformReqMsgType"/\>  
\<WL5G3N2:output message="WL5G3N3:TransformRespMsgType"/\>  
\</WL5G3N2:operation\>  
\</WL5G3N2:portType\>  
\<WL5G3N2:binding name="TransformationStreamingPortBinding"
type="WL5G3N3:TransformationService"\>  
\<WL5G3N1:Policy\>  
\<WL5G3N1:PolicyReference
URI="#TransformationStreamingPortBinding_MTOM_Policy-TransformationStreamingPortBinding_MTOM_Policy"/\>  
\<WL5G3N1:PolicyReference URI="#Mtom.xml"/\>  
\</WL5G3N1:Policy\>  
\<WL5G3N4:binding style="document"
transport="http://schemas.xmlsoap.org/soap/http"/\>  
\<WL5G3N2:operation name="transform"\>  
\<WL5G3N4:operation/\>  
\<WL5G3N2:input\>  
\<WL5G3N4:body use="literal"/\>  
\</WL5G3N2:input\>  
\<WL5G3N2:output\>  
\<WL5G3N4:body use="literal"/\>  
\</WL5G3N2:output\>  
\</WL5G3N2:operation\>  
\</WL5G3N2:binding\>  
\<WL5G3N2:service name="TransformationService"\>  
\<WL5G3N2:port binding="WL5G3N3:TransformationStreamingPortBinding"
name="TransformationStreamingPort"\>  
\<WL5G3N4:address
location="http://localhost:8080/converter_ws/ConverterHTI"/\>  
\</WL5G3N2:port\>  
\</WL5G3N2:service\>  
\</WL5G3N2:definitions\>

> <span id="_Toc85613428" class="anchor"></span>**Annex G: Validations
> done by STRUVAL**

<span id="_Toc428884494" class="anchor"></span>**Syntax Validation**

The syntax validation is done in a non-recoverable manner by using a
standard XML parser.

<span id="_Toc428884495" class="anchor"></span>**Structural Validation**

The following recoverable checks are performed against the SDMX message:

<table>
<colgroup>
<col style="width: 33%" />
<col style="width: 66%" />
</colgroup>
<thead>
<tr>
<th><strong>Error description</strong></th>
<th>Example</th>
</tr>
</thead>
<tbody>
<tr>
<td><strong>Illegal text</strong></td>
<td><p>&lt;/message:Header&gt;<br />
<strong>BLAH</strong></p>
<p>&lt;message:DataSet &gt;</p></td>
</tr>
<tr>
<td><strong>illegal attribute</strong></td>
<td>&lt;message:DataSet <strong>dummy="yes"</strong></td>
</tr>
<tr>
<td><strong>illegal element</strong></td>
<td><strong>&lt;Unexpected a="b"&gt;&lt;/Unexpected&gt;</strong></td>
</tr>
<tr>
<td><strong>series under series</strong></td>
<td>&lt;Series ADJUSTMENT="W" FREQ="Q" REF_AREA="IT"
STS_INDICATOR="PROD" STS_INSTITUTION="1" STS_ACTIVITY="NS0020"
STS_BASE_YEAR="2000" TIME_FORMAT="P1M"&gt;<br />
<strong>&lt;Series</strong></td>
</tr>
<tr>
<td><strong>obs under obs</strong></td>
<td>&lt;Obs TIME_PERIOD="2005-08" OBS_VALUE="1.53" OBS_CONF="F"
OBS_STATUS="A" &gt;<br />
&lt;Obs TIME_PERIOD="2005-12" OBS_VALUE="1.54" OBS_CONF="F"
OBS_STATUS="A" &gt;</td>
</tr>
<tr>
<td><strong>group under series (2.1 specific)</strong></td>
<td>&lt;/Series&gt;<br />
&lt;Group xsi:type="ns</td>
</tr>
<tr>
<td><strong>Non-flat with flat contents</strong></td>
<td><p>&lt;message:Structure structureID="ESTAT_STS_2_2"
namespace="urn:sdmx:org.sdmx.infomodel.datastructure.DataStructure=ESTAT:STS(2.2):ObsLevelDim:TIME_PERIOD"
<strong>dimensionAtObservation="TIME_PERIOD"</strong>&gt;</p>
<p>…</p>
<p>&lt;Obs ADJUSTMENT="W" FREQ="A" REF_AREA="IT" STS_INDICATOR="PROD"
STS_INSTITUTION="1" STS_ACTIVITY="NS0040" STS_BASE_YEAR="2000"
TIME_FORMAT="P1Y" TIME_PERIOD="2004-02" OBS_VALUE="1.2004" OBS_CONF="F"
OBS_STATUS="A" /&gt;</p></td>
</tr>
<tr>
<td><strong>Flat file with non-flat contents</strong></td>
<td><p>&lt;message:Structure structureID="ESTAT_STS_2_2"
namespace="urn:sdmx:org.sdmx.infomodel.datastructure.DataStructure=ESTAT:STS(2.2):ObsLevelDim:AllDimensions"
dimensionAtObservation="AllDimensions"&gt;<br />
...</p>
<p>&lt;Series ADJUSTMENT="W" FREQ="A" REF_AREA="IT" STS_INDICATOR="PROD"
STS_INSTITUTION="1" STS_ACTIVITY="NS0040" STS_BASE_YEAR="2000"
TIME_FORMAT="P1Y"&gt;</p></td>
</tr>
<tr>
<td><strong>Invalid XS attachment level. SDMX v2.0 Cross Sectional
Specific</strong></td>
<td>&lt;ns1:Section FREQ="A"</td>
</tr>
</tbody>
</table>

**Table 3 - Structural Validations**

<span id="_Toc428884496" class="anchor"></span>**Data Validation**

<table>
<colgroup>
<col style="width: 34%" />
<col style="width: 65%" />
</colgroup>
<thead>
<tr>
<th><strong>Error description</strong></th>
<th><strong>Example</strong></th>
</tr>
</thead>
<tbody>
<tr>
<td><strong>invalid code</strong></td>
<td>&lt;Series ADJUSTMENT="W" FREQ="A" REF_AREA="IT"
STS_INDICATOR="PROD" STS_INSTITUTION="1" STS_ACTIVITY="NS0040"
STS_BASE_YEAR="2000" <strong>TIME_FORMAT="P1A"</strong>&gt;</td>
</tr>
<tr>
<td><strong>missing dimension at series</strong></td>
<td>&lt;Series <del>ADJUSTMENT="W"</del> REF_AREA="LU" …&gt;</td>
</tr>
<tr>
<td><strong>missing mandatory attribute</strong></td>
<td>&lt;Obs TIME_PERIOD="2005-08" OBS_VALUE="1.53" OBS_CONF="F"
/&gt;</td>
</tr>
<tr>
<td><strong>invalid text format</strong></td>
<td>&lt;Obs TIME_PERIOD="2004-02" OBS_VALUE="FOO_BAR" OBS_CONF="F"
OBS_STATUS="A" /&gt;</td>
</tr>
<tr>
<td><strong>minValue</strong></td>
<td>Value should not be below minValue which is declared inside
structure file</td>
</tr>
<tr>
<td><strong>maxValue</strong></td>
<td>Value should not exceed the specified value in this attribute</td>
</tr>
<tr>
<td><strong>dim at obs at series/wrong dim at obs</strong></td>
<td>&lt;message:Structure structureID="ESTAT_STS_2_2"
namespace="urn:sdmx:org.sdmx.infomodel.datastructure.DataStructure=ESTAT:STS(2.2):ObsLevelDim:TIME_PERIOD"
<strong>dimensionAtObservation="TIME_PERIOD"</strong>&gt;<br />
… <strong>&lt;Series</strong> ADJUSTMENT="W"
<strong>TIME_PERIOD="2004-02"</strong> REF_AREA="IT"
STS_INDICATOR="PROD" STS_INSTITUTION="1" STS_ACTIVITY="NS0040"
STS_BASE_YEAR="2000" TIME_FORMAT="P1Y"&gt;<br />
<strong>&lt;Obs FREQ="A"</strong></td>
</tr>
<tr>
<td><strong>wrong attribute attachment level</strong></td>
<td>&lt;Group xsi:type="ns1:Sibling" REF_AREA="LU" ADJUSTMENT="W"
STS_INDICATOR="PROD" STS_ACTIVITY="NS0050" STS_INSTITUTION="1"
STS_BASE_YEAR="2000" ... <strong>TIME_FORMAT="P1Y"</strong>/&gt;</td>
</tr>
<tr>
<td><strong>dimension at dataset level</strong></td>
<td>&lt;message:DataSet <strong>ADJUSTMENT="W"</strong></td>
</tr>
<tr>
<td><strong>invalid time period value</strong></td>
<td>&lt;Obs TIME_PERIOD="2004-<strong>Q5</strong>"</td>
</tr>
<tr>
<td><strong>missing dimension at group</strong></td>
<td>&lt;Group xsi:type="ns1:Sibling" <del>REF_AREA="IT"</del>
ADJUSTMENT="W"</td>
</tr>
<tr>
<td><strong>duplicate observations</strong></td>
<td>&lt;Obs TIME_PERIOD="2004-02" OBS_VALUE="1.2004" OBS_CONF="F"
OBS_STATUS="A" /&gt; <strong>&lt;Obs TIME_PERIOD="2004-02"
OBS_VALUE="14" OBS_CONF="F" OBS_STATUS="A" /&gt;</strong></td>
</tr>
</tbody>
</table>

**Table 4 - Data validations**

<span id="_Toc477975027" class="anchor"></span>**Annex H: The structure
of a header file**

The full description of the header file can be found in the [<u>SDMX 2.0
section
03A</u>](https://sdmx.org/wp-content/uploads/SDMX_2_0_SECTION_03A_SDMX_ML.pdf)
online documentation.

header.id=JD014

header.test=true

header.truncated=false

header.name=Trans46302

header.prepared=2001-03-11T09:30:47-05:00

header.senderid=BIS

header.sendername=Bank for International Settlements

header.sendercontactname=G.B.Smith

header.sendercontactdepartment=Statistics

header.sendercontactrole=Statistician

header.sendercontacttelephone=210 2222222

header.sendercontactfax=210 00010999

header.sendercontactx400=

header.sendercontacturi=www.sdmx.org

header.sendercontactemail=gbsmith@sdmx.com

header.receiverid=ECB

header.receivername=European Central Bank

header.receivercontactname=John John

header.receivercontactdepartment=Statistics

header.receivercontactrole=Jack Over

header.receivercontacttelephone=210 1234567

header.receivercontactfax=210 3810999

header.receivercontactx400=x400

header.receivercontacturi=www.sdmx.org

header.receivercontactemail=lala@sdmx.com

header.datasetagency=BIS

header.datasetid=BIS_JD_237

header.datasetaction=Append

header.extracted=2001-03-11T09:30:47-05:00

header.reportingbegin=2000-01-01T00:00:00

header.reportingend=2006-01-01T00:00:00

header.reportingbegin=2000-12-01T00:00:00

header.source=StatApp

header.lang=en

header.keyfamilyref=JD

header.keyfamilyagency=ESTAT

<span id="_Ref458498641" class="anchor"></span>**Annex I: The structure
of a column mapping file**

<span id="_Toc477975029" class="anchor"></span>**Mapping for CSV**

This is how a file that maps input / output for CSV looks like:

\<?xml version="1.0" encoding="UTF-8"?\>

\<Mapping\>

\<Concept name="FREQ" value="1" level="1" fixed="false"/\>

\<Concept name="JD_TYPE" value="2" level="1" fixed="false"/\>

\<Concept name="JD_CATEGORY" value="3" level="1" fixed="false"/\>

\<Concept name="VIS_CTY" value="4" level="1" fixed="false"/\>

\<Concept name="TIME" value="5" level="1" fixed="false"/\>

\<Concept name="OBS_VALUE" value="6" level="1" fixed="false"/\>

\<Concept name="OBS_CONF" value="7" level="1" fixed="false"/\>

\<Concept name="OBS_STATUS" value="8" level="1" fixed="false"/\>

\<Concept name="OBS_PRE_BREAK" value="9" level="1" fixed="false"/\>

\</Mapping\>

The name of the concept contains one of the dimensions, attributes,
measures, the value contains either the column number or the fixed
value, the fixed flag is true/false in accordance with the value
attribute and the level is the an integer value representing the level
on which the value can be found (in the case of input CSV values) or the
level on which the value will be displayed.

<span id="_Toc46407931" class="anchor"></span>**Mapping for FLR**

This is how a file that maps input for Flr looks like:

\<?xml version="1.0" encoding="UTF-8"?\>

\<Mapping\>

\<Concept name="FREQ" value="1-3"/\>

\<Concept name="JD_TYPE" value="4-4"/\>

\<Concept name="JD_CATEGORY" value="5-5"/\>

\<Concept name="VIS_CTY" value="6-7"/\>

\<Concept name="TIME" value="8-14"/\>

\<Concept name="OBS_VALUE" value="15-16"/\>

\<Concept name="OBS_CONF" value="17-19+20-20"/\>

\<Concept name="OBS_STATUS" value="21-21"/\>

\<Concept name="OBS_PRE_BREAK" value="22-22"/\>

\<Concept name="AVAILABILITY" value="" level="1" fixed="true" /\>

\<Concept name="DECIMALS" value="1" level="" fixed="true" /\>

\<Concept name="BIS_UNIT" value="" level="" fixed="true" /\>

\<Concept name="UNIT_MULT" value="" level="" fixed="false" /\>

\<Concept name="TIME_FORMAT" value="" level="" fixed="false" /\>

\<Concept name="COLLECTION" value="" level="" fixed="false" /\>

\</Mapping\>

The name of the concept contains one of the dimensions, attributes,
measures, the value contains either the start/end character or the fixed
value, the fixed flag is true/false in accordance with the value
attribute and the level is the an integer value representing the level
on which the value can be found or the level on which the value will be
displayed. If the concept has complex or array values we can set
multiple values with the **plus** sign as it is displayed above with the
OBS_CONF.

In the mapping for an Flr output file “AUTO” is supported as value. To
enable “AUTO” functionality for a component in the mapping file, the
user should set fixed=”false” and value=”AUTO”. If auto is selected
means that length will be extracted from the input file for this
component.

<span id="_Toc495078247" class="anchor"></span>**Mapping for Multilevel
CSV**

Rules for creating a mapping file for multiple level CSV When creating a
mapping file, the user must follow all the rules from section 3.2 Rules
for creating a multi-level CSV file plus the following: 

· The mapping should contain all the dimensions, observations and
attributes (attached to Dataset, Group, Series, Observation) of the
DSD1.  And all of them are expected to have a value provided.

· No default mapping can be provided for multilevel CSV. The number of
levels inside the mapping file must be the same as the number of levels
declared in number of levels of CSV/FLR parameter.

· Ignoring a component is not currently permitted in multilevel CSV
files and all components must be provided a value/column. 

· Different from the flat input CSV case, for multiple level CSV the
supported number of columns per concept is only one and the same format
can be used both for output and input. The concatenator “+” is not
supported for multiple columns associated with the same concept. See
examples with supported values below:

If fixed=”false” then for CSV there can only be an integer value as a
String, meaning it takes the value from the respective column:  

 \<Concept name="COLLECTION" value="2" level="3" fixed="false" /\>

And for FLR an integer or a range, described using “-“:

\<Concept name="COLLECTION" value="2" level="3" fixed="false" /\>

COLLECTION takes the value from position 2 (a character only)

\<Concept name="COLLECTION" value="2-4" level="3" fixed="false" /\>

COLLECTION value will be taken from position 2 to 4. 

The following is not supported by multilevel CSV:  concatenate two or
more fields use the “+” character (plus symbol) supported only for flat
input CSV (number of levels = 1)

> \<?xml version="1.0" encoding="UTF-8"?\>
>
> \<Mapping\>
>
> \<Concept name="TAB_NUM" value="1" level="1" fixed="false"/\>
>
> \<Concept name="REV_NUM" value="2" level="1" fixed="false"/\>
>
> \<Concept name="FREQ" value="3" level="1" fixed="false"/\>
>
> \<Concept name="COUNTRY" value="4" level="2" fixed="false"/\>
>
> \<Concept name="SEX" value="5" level="2" fixed="false"/\>
>
> \<Concept name="DEMO" value="6" level="2" fixed="false"/\>
>
> \<Concept name="UNIT_MULT" value="7" level="2" fixed="false"/\>
>
> \<Concept name="DECI" value="8" level="2" fixed="false"/\>
>
> \<Concept name="TIME_FORMAT" value="9" level="2" fixed="false"/\>
>
> \<Concept name="UNIT" value="10" level="2" fixed="false"/\>
>
> \<Concept name="TIME" value="11" level="3" fixed="false"/\>
>
> \<Concept name="OBS_VALUE" value="12" level="3" fixed="false"/\>
>
> \<Concept name="OBS_STATUS" value="13" level="3" fixed="false"/\>
>
> \</Mapping\>

<span id="_Toc495078248" class="anchor"></span>**Mapping for SDMX CSV**

SDMX CSV format does not use a mapping. The order from the DSD  is
expected to be followed but grouped by type as the following:
*dimensions, time, observation value, observation level attributes,
other attributes.*

<span id="_Toc477975031" class="anchor"></span>**Fixed values example**

For both CSV and FLR mapping files, the user can set a fixed value for a
component. When trying to convert a message of CSV or FLR format to an
SDMX-ML some columns may not be present because the data is implied. For
example the column for the ‘REF_COUNTRY’ concept may be omitted. In that
case user can set a fixed value in the mapping dialog for the absent
column.

Another sample of an XML mapping file, applicable for an FLR input file
is shown below:

\<?xml version="1.0" encoding="UTF-8"?\>

\<Mapping\>

\<Concept name="FREQ" value="ANNUAL" level="" fixed="true"/\>

\<Concept name="JD_TYPE" value="1-1" level="" fixed="false"/\>

\<Concept name="JD_CATEGORY" value="2-2" level="" fixed="false"/\>

\<Concept name="VIS_CTY" value="3-4" level="" fixed="false"/\>

\<Concept name="TIME" value="5-11" level="" fixed="false"/\>

\<Concept name="OBS_VALUE" value="12-13" level="" fixed="false"/\>

\<Concept name="OBS_CONF" value="14-16+17-17" level="" fixed="false"/\>

\<Concept name="OBS_STATUS" value="18-18" level="" fixed="false"/\>

\<Concept name="OBS_PRE_BREAK" value="19-19" level="" fixed="false"/\>

\</Mapping\>

\* FREQ correlates with the value of column 1

\* OBS_CONF is a complex concept and will contain two values one will be
characters 14-16 and the second will be character in position 17.

A user can also specify a fixed value in case he/she wants to replace an
existing one and cannot use the transcoding procedure. For example a
user may want to replace an existing value for an observation attribute
which might not have a codelist thus cannot be transcoded

<span id="_Toc477975032" class="anchor"></span>**Mapping for cross
sectional files**

When converting from a CSV file using a Cross Sectional DSD, the cross
sectional measures that belong to a series might appear in one record
rather than in consecutive rows. The following two file structures might
appear when converting with a cross sectional DSD:

1.  In the first structure each observation value appears along with the
    cross sectional measure in one row. Each cross sectional measure
    appears in the same row in each record (4th column).

A;GR;F;DEATHST;2005;23871;P

A;GR;F;EMIGT;2005;6331;P

A;GR;F;IMMIT;2005;10581;P

A;GR;F;LBIRTHST;2005;28345;P

For this kind of files, the measure dimension is always mapped to the
specific column. In the above sample for the Country Greece (GR) and for
female (F) the annual (A) observation values are reported consecutively
in rows and correspond to Deaths (DEATHST), Emigrants (EMIGT),
Immigrants (IMMIT) and Births (LBIRTHST) respectively.

1.  In the second file structure the components that correspond to cross
    sectional measures do not appear in the CSV, but only their values.

A;GR;F; 23871; 6331;10581;28345;2005;P

In the above record of the CSV file only the observation values that
correspond to the cross sectional measures appear. Specifically the
value 23871 is the measure of Deaths, the value 6331 of Emigrants, the
value of 10581 of Immigrants and the value 28345 of Births. In the CSV
input parameters screen the user should select to map cross sectional
measures and map each measure to a column in the mapping screen. For
this example the measure DEATHST has been mapped to column 4, the
measure EMIGT to column 5, the measure IMMIT to column 6 and the measure
LBIRTHST to column 7. In that way the user does not have to map the
observation value as this will not appear in a specific column in the
CSV file but will appear in the column that the respective cross
sectional measure has been mapped

<span id="_Toc46407936" class="anchor"></span>**Mapping for files
containing explicit Measures**

When converting from a FLR file to CSV using a DSD that contains
explicit measures, those measures might appear in one record rather than
in consecutive rows. The following two file structures might appear when
converting with a DSD that contains explicit measures:

In the first structure each observation value appears along with the
measure in one row. Each explicit measure appears in the same row in
each record (2nd column).

> HHSEQNUM;MEASURE;OBS_VALUE
>
> 03;NOWKREAS;3
>
> 03;PROXY;01

For this kind of files, the measure dimension is always mapped to the
specific column.

In the second file structure the components that correspond to explicit
measures do not appear in the CSV, but only their values. To achieve the
following output the user must provide a mapping file for the explicit
measures that will replace the MEASURE dimension and have to set the
parameter UseExplicitMeasures=true or check the corresponding checkbox
for the desktop application or the web application.

> HHSEQNUM;NOWKREAS;PROXY;
>
> 03;3;01

In the above record of the CSV file only the observation values that
correspond to the explicit measures appear. The user does not have to
map the observation value as this will not appear in a specific column
in the CSV file but will appear in the column that the respective
explicit measure has been mapped.

<span id="_Toc477975034" class="anchor"></span>**Annex J: The structure
of an excel parameter sheet mapping file or sheet**

The following example shows a mapping between value-sheets (Data1,
Data2, and Data3) and parameters sheets (Parameters_Data1,
Parameters_Data2) in an external txt file:

Data1=Parameters_Data1

Data2=Parameters_Data2

Data3=Parameters_Data2

The following example shows a mapping between value-sheets and the
parameter sheets inside the excel data file as a sheet with the name
Parameter_mapping:

| Data Sheet | Parameter Sheet  |
|------------|------------------|
| Data1      | Parameters_Data1 |
| Data2      | Parameters_Data2 |

The headers “Data Sheet” and “Parameter Sheet” must exist at the first
row of the sheet.

The external txt mapping file can only be used by webservice as txt. In
all modules you can include the mapping file inside the excel parameters
file.

<span id="_Ref458498847" class="anchor"></span>**Annex K: The structure
of a transcoding file**

The following file is an example of a transcoding file:

\<?xml version="1.0" encoding="UTF-8"?\>

\<mes:Structure
xmlns:mes="http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message"
xmlns:str="http://www.SDMX.org/resources/SDMXML/schemas/v2_0/structure"\>

\<mes:Header\>

\<mes:ID\>IDREF1\</mes:ID\>

\<mes:Test\>false\</mes:Test\>

\<mes:Prepared\>2016-08-10T14:38:11.402+03:00\</mes:Prepared\>

\<mes:Sender id="Unknown"/\>

\<mes:Receiver id="Unknown"/\>

\</mes:Header\>

\<mes:StructureSets\>

\<str:StructureSet agencyID="DummyID"

id="Id_for_StructureSet"
urn="urn:sdmx:org.sdmx.infomodel.mapping.StructureSet=DummyID:Id_for_StructureSet(1.0)"
version="1.0"\>

\<str:Name xml:lang="en"\>Name of StructureSet\</str:Name\>

\<str:CodelistMap id="FREQ"\>

\<str:Name xml:lang="en"\>Name of CodelistMap\</str:Name\>

\<str:CodelistRef\>
\<str:URN\>urn:sdmx:org.sdmx.infomodel.codelist.Codelist=ESTAT:CL_FREQ(1.0)\</str:URN\>

\<str:AgencyID\>ESTAT\</str:AgencyID\>

\<str:CodelistID\>CL_FREQ\</str:CodelistID\>

\<str:Version\>1.0\</str:Version\>

\</str:CodelistRef\>

\<str:TargetCodelistRef\>

\<str:URN\>urn:sdmx:org.sdmx.infomodel.codelist.Codelist=ESTAT:CL_FREQ(1.0)\</str:URN\>

\<str:AgencyID\>ESTAT\</str:AgencyID\>

\<str:CodelistID\>CL_FREQ\</str:CodelistID\>

\<str:Version\>1.0\</str:Version\>

\</str:TargetCodelistRef\>

\<str:CodeMap\>

\<str:MapCodeRef\>annuel\</str:MapCodeRef\>

\<str:MapTargetCodeRef\>A\</str:MapTargetCodeRef\>

\</str:CodeMap\>

\<str:CodeMap\>

\<str:MapCodeRef\>semestriel\</str:MapCodeRef\>

\<str:MapTargetCodeRef\>S\</str:MapTargetCodeRef\>

\</str:CodeMap\>

\<str:CodeMap\>

\<str:MapCodeRef\>trimestiel\</str:MapCodeRef\>

\<str:MapTargetCodeRef\>Q\</str:MapTargetCodeRef\>

\</str:CodeMap\>

\</str:CodelistMap\>

\</str:StructureSet\>

\</mes:StructureSets\>

\</mes:Structure\>

<span id="_Toc477975038" class="anchor"></span>**Annex L: Conversion
limitations**

<span id="_Toc477975039" class="anchor"></span>**CSV/FLR limitations**

In order for a flat CSV or FLR file to be converted successfully some
limitations exist. Each line in such a file represents one record. This
implies that no new line characters should be present inside the data in
that record. In cases where the text contains new line characters, the
user should supress all new line characters.

For flat CSV files also the attributes at a higher level than
Observation are processed.

The user has to repeat the respective attribute on every related
observation if not the first encountered value is used and the rest are
ignored. In case the values of the attributes other than the Observation
level are not the same for the same group or time series then a warning
is printed in the log. The conversion will be successful using the first
encountered value.

In the mapping file all the dimensions, attributes, primary measure,
time reference etc must be provided according to the DSD.

For multilevel files and those containing groups is mandatory to have
the data ordered - rows for the same series or group are consecutive
(Input Ordered). Input has to be ordered also when converting to cross
sectional format.

Also for **multilevel** the following rules apply:

- The lower the level number, the higher is the priority of that level
  in the CSV file.

- The first column is considered a level identifier, meaning it defines
  the level of the record. The implementation expects it at the
  beginning of each row both for CSV and FLR

- As soon as level n is reached in the file, the previous information
  for levels higher than n are no longer useful.

- For each level the expected order is Group, Dataset, Series, Time and
  Observation. There can be more on the same level (i.e. Dataset and
  Series attributes on the same level) but having Observation on level 1
  and Dataset attributes on level 3 might lead to an erroneous result.
  Therefore, observation and observation attributes are expected on the
  last levels.

- Each level must have at least one value. Providing 4 levels but having
  an empty row for level 3 is incorrect.

- Multilevel CSV does not support a header row (both for input and for
  output). Meaning for multilevel case “Header row” is false.

- In the input file the number of columns (delimiters) per level is
  equal. Meaning that a for the same level, the same number must be
  provided. E.g. all rows starting with 2 (for level 2 records) will
  have the same number of columns (hence delimiters)

- The column semantic per level is equivalent. Related to the mapping
  and to affirmation above it is expected that the csv file (equally
  input or output) at the same level, the same column holds the same
  semantic. E.g. below, the second column for third level will represent
  the TIME dimension value:

1;RQFI05V1;1;A

2;FI;F;ADJT;0;0;P1Y;PERS

3;**2005**;35;P

3;**2006**;55;P

3;**2007**;38;P

- The order of the levels for each group should be correct, in the sense
  that each level is considered a child of the previous higher level
  encountered in the file. The example below is wrong.
  3;2000-01;1.113;;A;; is assumed to belong to group 1;C because level 2
  is placed in a wrong location:

1;C

3;2000-01;1.113;;A;;

2;ANN;Amounts;M

3;2000-04;5.2;;A;;

- The group values should be unique: The same group values should not
  appear later in the file as it will be considered a different group
  (key). The example below Converter will consider a new group when
  encountering twice the same information:

> 1;P
>
> 2;MON;Amounts;M

**1;P**

**2;MON;Amounts;M**

3;2000-01;3.14;;A;;

3;2000-01;1.113;;A;;

2;ANN;Amounts;M

3;2000-04;5.2;;A;;

3;2000-09;5.2;;A;;

1;A

2;MON;Amounts;M

3;2000-04;5.55;;A;;

**1;P**

**2;MON;Amounts;M**

3;2000-02;4.54;;A;;

Last two affirmations are related to the input order. For multilevel
files and those containing groups is mandatory to have the data
ordered - rows for the same series or group are consecutive (Input
Ordered). Input must be ordered also when converting to cross sectional
format.

In other words, the order of records is expected to be consistent, in
the sense that each level is considered a child of the previously higher
lever encountered in the file, also the same group should not appear
later in the file as it will be considered a different group (key).

<span id="_Toc477975040" class="anchor"></span>**Limitations for Message
Group messages**

The message group is not an input format (as Generic or Compact are) but
just a hint to Converter that the input file should be treated
differently. The Message Group allows more than one data message to be
included in a single transmission. Currently, Converter supports Message
Group as input sdmx-ml file for all four different representations of
reporting datasets: Generic data message, Compact data Message, Utility
data Message and Cross Sectional Data Message. The only limitation the
user has when converting a message group file is that the input file
must have only ONE dataset reported in the message

<span id="_Toc477975041" class="anchor"></span>**Limitations when
converting to/from Cross Sectional**

The selected DSD for these files must support cross-sectional messages
i.e. having defined cross-sectional measures and cross-sectional
attachment levels for its components (see SDMX standard
[<u>www.sdmx.org</u>](http://www.sdmx.org))

A special case is the conversion from Cross Sectional to SDMX 2.1
messages where the provided data structure has to be valid with Time
dimension or cross sectional measures.

<span id="_Toc477975042" class="anchor"></span>**Limitations when
converting from SDMX 2.1 to other formats**

With exception of SDMX V2.1 formats no other format supports multiple
datasets in a single data message. Consequently Converter only supports
conversions of SDMX V2.1 files having a single dataset per message. Also
conversion from SDMX 2.1 to SDMX 2.0 formats is possible only when the
DSD is compatible with both formats. The compatibility with V2.0 formats
is checked in SDMX Source API before conversion begins.

<span id="_Toc477975043" class="anchor"></span>**Limitations when
converting from Gesmes TS**

In GESMES/TS (SDMX-EDI) there are 2 kinds of observation attributes:

> the observation flags which are part of the ARR segments
>
> the normal attributes that are included in the attribute section.

The observation flags are fixed. They are the observation status,
observation confidentiality and observation pre-break. In SDMX-ML the
concept of "observation flags" does not exist. In order to map between
SDMX-ML DSD observation attributes and SDMX-EDI observation flags the
OBS_CONF or CONF_STATUS are considered to be the concept for
“observation confidentiality”. Also OBS_PRE_BREAK or PRE_BREAK_VALUE are
considered to be the concept for "observation pre-break". **These
attribute names are hard-coded in SDMX Converter** and, at conversion
time, checked which one exists in DSD to be used in the output. If any
of these names was not found in DSD the OBS_CONF/OBS_PRE_BREAK pair is
used.

**Having said that, the following limitations may occur when converting
from Gesmes TS:**

If in the future other attributes names will be used in DSD for
observation flags in GESMES/TS the Converter needs to be updated as the
above names are hard coded.

Parsing of ARR segment in the input Gesmes file is dependent by the
value of the frequency code. As the frequency code lists could evolve
over time Converter needs to be updated in order to support new codes.

Currently Converter supports A, H, Q, M, W, B or D as values for
frequency in the Gesmes file. B and D are interpreted in the same way.

**Sibling group wildcard**

In GESMES/TS (SDMX-EDI) there is the possibility to use wildcard for
dimensions in a sibling group (e.g. **ARR+4+:XX:ZZ:CC'** - this is a
sibling group with FREQ wildcarded). Cross sectional 2.0 (CROSS_SDMX)
does not support groups. So, to be able to make the conversion to cross
sectional as well, it will be translated to the corresponding series for
each FREQ code from the codelist instead being converted to a sibling
group.

This means that for **ARR+4+:XX:ZZ:CC'** input**,** instead of
converting to a sibling group as below:

**\<bis:SiblingGroup JD_TYPE="XX" JD_CATEGORY="XX" VIS_CTY="CC"/\>**

The conversion will be made to series like this (below is a COMPACT_SDMX
example):

**\<bis:Series FREQ="A" JD_TYPE="XX" JD_CATEGORY="XX" VIS_CTY="CC"/\>**

**\<bis:Series FREQ="D" JD_TYPE="XX" JD_CATEGORY="XX" VIS_CTY="CC"/\>
\<bis:Series FREQ="H" JD_TYPE="XX" JD_CATEGORY="XX" VIS_CTY="CC"/\>**

**\<bis:Series FREQ="M" JD_TYPE="XX" JD_CATEGORY="XX" VIS_CTY="CC"/\>
\<bis:Series FREQ="Q" JD_TYPE="XX" JD_CATEGORY="XX" VIS_CTY="CC"/\>**

**\<bis:Series FREQ="W" JD_TYPE="XX" JD_CATEGORY="XX" VIS_CTY="CC"/\>**

<span id="_Toc477975044" class="anchor"></span>**Detection of input
format**

Converter application is only able to detect the SDMX 2.0, SDMX 2.1,
SDMX 3.0 and Excel formats. In case the format cannot be detected the
user will get a notification message.

<span id="_Toc495078260" class="anchor"></span>**Annex M: How to
configure the excel readers (Excel parameter sheet contents)**

Parameter File is used as layout description of the Excel input file. If
the external parameter file is provided and mapping parameter is not
provided, then the external parameter file will be used for all data
sheets even if the Excel file contains other parameter sheets.

> The external parameter file must follow the rules below:

- All the contained data must be separated by space. Only the value
  after FIX position type can have a value containing space character.

- The parameter file must contain on the first row the column headers.

- The Element is the name of the dimension or attribute exactly as it is
  named in the DSD file.

- The Type can only be DIM (dimension), ATT (attribute) and MES
  (measure). When multiple measures are defined then enumerate with a
  blank space as a suffix. For example:

| <span class="mark">MEASURE 1</span> |
|-------------------------------------|
| <span class="mark">MEASURE 2</span> |

- **PosType** is CELL, ROW, COLUMN, FIX, SKIP, OBS_LEVEL or MIXED.

- **Occurrences** is the number of occurrences this concept will appear.
  This is used when the concept has multiple/array values. Valid values
  are a range of min and max number of occurrences for example 1-2 or
  1-unbounded. Blank is also an acceptable value for this field.

- **DataStart** is the position where the actual data starts.

- **DataEnd** is the position where the actual data ends. If DataEnd is
  specified, the converter will read until that limit and ignore the
  maximum of empty rows/column. To have multiple pairs of DataStart/End
  for one DataSheet then use parameter mapping sheet inside Excel file
  and map different parameter sheets for the same DataSheet.

- Either **NumColumns**, the number of columns containing data, or
  **MaxEmptyRows**, the maximum row allowed to be empty before finishing
  reading data, must be provided. Valid values are integers greater than
  zero.

- DataStart, DataEnd and NumColumns (or MaxEmptyRow) can be defined to
  the left of the Elements or at the end of the file.

- **MaxEmptyColumns**, the maximum number of empty cells allowed in the
  current row before start reading the next row. If not present the
  default is 1000.

- **TrancodingSheet**, specify the name of the sheet containing a
  mapping between the couple text/dimension and the SDMX value. For the
  structure of the transcoding sheet see [<u>appendix
  V</u>](#_Annex_V:_The)

- **The Transcoding Sheet name must start with “Trans” to avoid parsing
  it as data Sheet for example:**

| TranscodingSheet | Trans_1 |
|------------------|---------|

> A transcoding sheet can be present inside external parameter sheet or
> inside input file, but always must be declared inside parameter sheet.
> If transcoding sheet exists inside both files the below priorities are
> followed.
>
> **1<sup>st</sup> Priority:** Parameters external + transcoding
> external
>
> **2<sup>nd</sup> Priority:** Parameters external + transcoding
> internal
>
> **3<sup>rd</sup> Priority:** Parameters Internal + transcoding
> internal

- **SkipRows**, this parameter should be used to skip one or several
  rows. This parameter contains the number of the row(s) to be skipped.
  For multiple rows to be skipped you can put number of rows in a list
  with commas inside the same cell:

| SkipRows | 24,25,26 |
|----------|----------|

> or you can put the parameter multiple times inside the parameter
> sheet:

| SkipRows | 24  |
|----------|-----|
| SkipRows | 25  |

- **SkipColumns**, this parameter should be used to skip one or several
  columns. The skip is only for observation itself.

- **SkipObservationWithValue**, skip observation with certain value,
  converter will skip and ignore this observation.

- **SkipIncompleteKeys**, skip observations with empty or wrong
  dimension or concept values when value is set to true. Default value
  is set to true.

- **ConceptSeparator**, character that separates multiple concepts
  defined in the same cell. In the parameter sheet you can define the
  position inside the cell that indicates the value for this concept
  with the slash character:

| REF_AREA | DIM | CELL | B1/2 |
|----------|-----|------|------|

> And inside data Sheet the converter will search the cell B1 and the
> first position separated with the character defined by the
> ConceptSeparator. For example if the concept separator is “;” and in
> Data Sheet the B1 cell has the value DE;PROD then the REF_AREA for the
> above example will be assigned the value PROD. ConceptSeparator can be
> defined for Position Types Cell, Rows and Columns, OBS_LEVEL and
> MIXED.

- **SubfieldSeparator,** set for multiple measures, to be able to
  distinguish the multiple values in the same field.

- **MissingObservationCharacter**, if set at an observation cell
  converter treats the observation as missing. If DefaultValue is set
  this value will be assigned.

- **roundToFit,** if this parameter is present must have value true or
  false. After an observation value is rounded according to parameter
  *Rounding Precision*, the value is checked again and if the number of
  digits that remain are more from the ***maxLength*** attribute of the
  DSD, then the value is rounded again (with Round Half algorithm) to
  the number of digits declared in the DSD.

- **CodesFromExternalFile,** the value expected in this parameter is the
  name of another sheet which is “pre-processing sheet”. The
  pre-processing sheet contains codes that can be matched to DSD.
  Elements not affected that should always be read from the input
  file/sheet:

  - obs_value / the measure

  - obs_level attributes

- **formatValues,** Excel stores numbers differently that you may have
  them formatted on the worksheet. When the actual value of cells is
  needed for the output, we need to set this parameter on the parameter
  sheet with the value *<u>actualValue.</u>* The **default value** is
  <u>*customFormat*</u> which means for the custom formatted cells the
  output will be the value displayed by cell including the formatting
  but for numbers the actual value is computed except the cells that
  have a custom format defined by the user. If only the displayed values
  needed, then set the parameter with the value *<u>asDisplayed</u>*. If
  this parameter is not set or another invalid value is selected, then
  the <u>*customFormat*</u> behavior is used.

> *In general, for numeric elements (as defined in the DSD), the leading
> or trailing whitespaces from the values are trimmed.*
>
> As *<u>custom format</u>* is recognized every format that is defined
> by the user. The following table indicates the formats that are not
> considered as custom formats, everything else is considered custom:

| 0, | "General" |
|--------|----------------------------------------------------------------|
| 1, | "0" |
| 2, | "0.00" |
| 3, | "#,##0" |
| 4, | "#,##0.00" |
| 5, | "$#,##0\_);($#,##0)" |
| 6, | "$#,##0\_);\[Red\]($#,##0)" |
| 7, | "$#,##0.00);($#,##0.00)" |
| 8, | "$#,##0.00\_);\[Red\]($#,##0.00)" |
| 9, | "0%" |
| 0xa, | "0.00%" |
| 0xb, | "0.00E+00" |
| 0xc, | "# ?/?" |
| 0xd, | "# */*" |
| 0xe, | "m/d/yy" |
| 0xf, | "d-mmm-yy" |
| 0x10, | "d-mmm" |
| 0x11, | "mmm-yy" |
| 0x12, | "h:mm AM/PM" |
| 0x13, | "h:mm:ss AM/PM" |
| 0x14, | "h:mm" |
| 0x15, | "h:mm:ss" |
| 0x16, | "m/d/yy h:mm" |
|  | // 0x17 - 0x24 reserved for international and undocumented 0x25, "#,##0\_);(#,##0)" |
| 0x26, | "#,##0\_);\[Red\](#,##0)" |
| 0x27, | "#,##0.00\_);(#,##0.00)" |
| 0x28, | "#,##0.00\_);\[Red\](#,##0.00)" |
| 0x29, | "*(**#,##0*****);*(****(#,##0);*(\* \\-\\*);*(@\_)" |
| 0x2a, | "*($**#,##0*****);*($****(#,##0);*($\* \\-\\*);*(@\_)" |
| 0x2b, | "*(**#,##0.00*****);*(****(#,##0.00);*(\*\\-\\??*);*(@\_)" |
| 0x2c, | "*($**#,##0.00*****);*($****(#,##0.00);*($\*\\-\\??*);*(@\_)" |
| 0x2d, | "mm:ss" |
| 0x2e, | "\[h\]:mm:ss" |
| 0x2f, | "mm:ss.0" |
| 0x30, | "##0.0E+0" |
| 0x31, | "@" - This is text format. |
| 0x31 | "text" - Alias for "@" |

- When **MIXED** is used as PosType not all the combinations are
  allowed. For example

- VALUATION DIM MIXED COLUMNS 5 ROW 20 is a valid description if COLUMN
  5 is found empty ROW 20 will be used.

- The same for VALUATION DIM MIXED CELL B5 FIX 23 if CELL B5 is empty
  the FIX value ‘23’ will be used.

- Unaccepted combinations are between FIX, SKIP, OBS_VALUE. e.g. MIXED
  OBS_VALUE 1 FIX 25 will fail.

- When OBS_LEVEL appears, the column corresponding to the Observation
  values is expected to exist even if OBS_LEVEL is part of MIXED
  position type.

- e.g. For the declaration below, if H14 cell is found non empty the
  converter application will skip one column to the right which
  represents the observation level attributes that can be empty or non
  empty.

| **OBS_STATS** | **ATT** | **MIXED** | **CELL** | **H14** | **OBS_LEVL** | **1** |
|---------------|---------|-----------|----------|---------|--------------|-------|

- For MIXED the values are checked for each Observation. So, for the
  example below for each Observation the observation level is checked
  and it the cell at that corresponding position is empty the value from
  the cell H14 will be used.

| **OBS_STATS** | **ATT** | **MIXED** | **OBS_LEVEL** | **1** | **CELL** | **H14** |
|---------------|---------|-----------|---------------|-------|----------|---------|

- If an Observation value is left empty intentionally, the data sender
  might to transmit further attributes (e.g. OBS_STATUS), giving
  reasoning on the fact that the observation is blank. For this a new
  parameter is added called “DefaultValue”. This parameter is optional.
  If present and all the mandatory dimensions can be resolved when
  parsing the empty observation cell, the Converter will create an
  observation with the observation value equals with the value specified
  in the DefaultValue parameter (this could be either a 0, a " " or a
  "NaN" for example, the converter will only put the value specified in
  the output file). There is a special value for DefaultValue. If
  *DefaultValue = null* then in the output an observation with empty
  value is created. This parameter can be defined to the left of the
  Elements in the second group of parameters (DataStart, MaxEmptyRows).

> **DefaultValue “NaN”**

- For all cells storing NUMBERs, Excel uses internally a rounding
  mechanism in order to avoid displaying floating point approximations
  induced by the IEEE 754 standard (see [<u>appendix
  E</u>](#_APPENDIX_E_–) and [<u>appendix F</u>](#_APPENDIX_F_–) for
  more details). To control the rounding performed by Converter for
  Excel decimal numbers, a new parameter (RoundingPrecision) has been
  introduced and will be applied for converting the values from all
  cells storing NUMBERs as well as from cells having a formula which
  evaluates to a NUMBER.

> The RoundingPrecision parameter is optional, if not present Converter
> uses 6 as default precision number. The parameter value should be an
> integer between 0 and 15. If it is 0 the numbers will be rounded
> without decimals. If the parameter value is greater than 15 then the
> value will be ignored and 15 will be used. If the parameter value is a
> negative integer, then the default value (6) is used.
>
> **RoundingPrecision 4**
>
> The same rules apply to Excel Parameter Sheets with the difference
> that each piece of information is stored in its own cell instead of
> being separated by spa.

<span id="_Ref458503574" class="anchor"></span>**Annex N: The structure
of an excel parameter file**

- The following example is a potential parameter sheet inside the excel:

| **Element** | **Type** | **PosType** | **Position** |  | DataStart | D24 |
|----------------|-------|---------|----------|-------|-----------------|--------|
| REF_AREA | DIM | CELL | B1/1 |  | MaxNumOfEmptyColums | 1 |
| STS_INDICATOR | DIM | CELL | B1/2 |  | ConceptSeparator | ; |
| STS_INSTITUTION | DIM | FIX | 1 |  | NumColumns | 6 |
| STS_BASE_YEAR | DIM | CELL | B7 |  | TranscodingSheet | Trans_1 |
| FREQ | DIM | CELL | I14 |  | SkipRows | 31 |
| STS_ACTIVITY | DIM | COLUMN | B/1 |  | SkipObservationWithValue | 0 |
| TIME_PERIOD | DIM | ROW | 23 |  | DataEnd | I31 |
| OBS_STATUS | ATT | CELL | D2/1 |  |  |  |
| OBS_CONF | ATT | CELL | D2/2 |  |  |  |
| ADJUSTMENT | DIM | MIXED | COLUMN | A | ROW | 21 |
| OBS_ATT | ATT | FIX | P |  |  |  |
| TITLE | ATT | SKIP |  |  |  |  |
| UNIT | ATT | SKIP |  |  |  |  |
| UNIT_MULT | ATT | SKIP |  |  |  |  |
| DECIMALS | ATT | SKIP |  |  |  |  |
| COLLECTION | ATT | SKIP |  |  |  |  |
| AVAILABILITY | ATT | SKIP |  |  |  |  |
| UNIT_INDEX_BASE | ATT | SKIP |  |  |  |  |
| TITLE_COMPL | ATT | SKIP |  |  |  |  |
| NAT_TITLE | ATT | SKIP |  |  |  |  |
| DOM_SER_IDS | ATT | SKIP |  |  |  |  |
| COMPILATION | ATT | SKIP |  |  |  |  |
| BREAKS | ATT | SKIP |  |  |  |  |
| COVERAGE | ATT | SKIP |  |  |  |  |
| SOURCE_PUB | ATT | SKIP |  |  |  |  |
| SOURCE_AGENCY | ATT | SKIP |  |  |  |  |
| OBS_COM | ATT | SKIP |  |  |  |  |
| TIME_FORMAT | ATT | FIX | P1Y |  |  |  |
| OBS_PRE_BREAK | ATT | SKIP |  |  |  |  |

- As far as SDMX 3.0 multiple measures and array values support in the
  Parameter Sheet there are three main features to be considered. An
  **occurrences column** next to the components positions in which the
  minimum occurrences and maximum occurrences for this component is
  defined. Also, the user can define a **SubfieldSeparator** character
  that separates multiple values defined in the same cell. Finally, for
  a multiple valued component, the user can add the **concept followed
  by space and an increment number** and those entries will be
  considered as multiple values of the same concept. An example is shown
  below, with the SDMX 3.0 features highlighted:

| **Element** | **Type** | **PosType** | **Position** |  |  |  | **Occurrences** |  | DataStart | B23 |
|------------|------|-------|--------|----|-----|------|---------|---|-----------|-----|
| ACCOUNTING_ENTRY | DIM | ROW | 21 |  |  |  |  |  | NumColums | 17 |
| ACTIVITY | DIM | ROW | 20 |  |  |  |  |  | ConceptSeparator | ) |
| ACTIVITY_TO | DIM | SKIP |  |  |  |  |  |  | SubfieldSeparator | \# |
| ADJUSTMENT | DIM | CELL | H10 |  |  |  |  |  |  |  |
| CONSOLIDATION | DIM | SKIP |  |  |  |  |  |  |  |  |
| COUNTERPART_AREA | DIM | CELL | B6 |  |  |  |  |  |  |  |
| COUNTERPART_SECTOR | DIM | CELL | B7 |  |  |  |  |  |  |  |
| CURRENCY_DENOM | DIM | SKIP |  |  |  |  |  |  |  |  |
| CUST_BREAKDOWN | DIM | SKIP |  |  |  |  |  |  |  |  |
| EXPENDITURE | DIM | CELL | B11 |  |  |  |  |  |  |  |
| FREQ | DIM | CELL | H2 |  |  |  |  |  |  |  |
| INSTR_ASSET | DIM | CELL | B9 |  |  |  |  |  |  |  |
| MATURITY | DIM | SKIP |  |  |  |  |  |  |  |  |
| PRICES | DIM | CELL | H5 |  |  |  |  |  |  |  |
| PRODUCT | DIM | SKIP |  |  |  |  |  |  |  |  |
| PRODUCT_TO | DIM | SKIP |  |  |  |  |  |  |  |  |
| REF_AREA | DIM | CELL | B3 |  |  |  |  |  |  |  |
| REF_SECTOR | DIM | CELL | B5 |  |  |  |  |  |  |  |
| STO | DIM | ROW | 19 |  |  |  |  |  |  |  |
| TIME_PERIOD | DIM | COLUMN | 1 |  |  |  |  |  |  |  |
| TRANSFORMATION | DIM | CELL | H11 |  |  |  |  |  |  |  |
| UNIT_MEASURE | DIM | CELL | H7 |  |  |  |  |  |  |  |
| VALUATION | DIM | SKIP |  |  |  |  |  |  |  |  |
| COLL_PERIOD | ATT | SKIP |  |  |  |  |  |  |  |  |
| COMMENT_DSET | ATT | CELL | H8/1 |  |  |  |  |  |  |  |
| COMMENT_OBS | ATT | SKIP |  |  |  |  |  |  |  |  |
| COMMENT_TS | ATT | CELL | L10 |  |  |  |  |  |  |  |
| COMPILING_ORG | ATT | SKIP |  |  |  |  |  |  |  |  |
| CONF_STATUS | ATT | MIXED | OBS_LEVEL | 1/2 | CELL | H14/2 |  |  |  |  |
| CUST_BREAKDOWN_LB | ATT | SKIP |  |  |  |  |  |  |  |  |
| DECIMALS | ATT | CELL | H9 |  |  |  |  |  |  |  |
| EMBARGO_DATE | ATT | CELL | H12 |  |  |  |  |  |  |  |
| GFS_ECOFUNC | ATT | SKIP |  |  |  |  |  |  |  |  |
| GFS_TAXCAT | ATT | SKIP |  |  |  |  |  |  |  |  |
| LAST_UPDATE | ATT | CELL | H13 |  |  |  |  |  |  |  |
| OBS_EDP_WBB | ATT | SKIP |  |  |  |  |  |  |  |  |
| OBS_STATUS | ATT | MIXED | OBS_LEVEL | 1/1 | CELL | H14/1 |  |  |  |  |
| REF_PERIOD_DETAIL | ATT | CELL | B4 |  |  |  |  |  |  |  |
| REF_YEAR_PRICE | ATT | CELL | H6 |  |  |  |  |  |  |  |
| TABLE_IDENTIFIER | ATT | CELL | B2 |   |   |   | **1-unbounded** |  |  |  |
| TIME_FORMAT | ATT | CELL | H4 |  |  |  |  |  |  |  |
| TIME_PER_COLLECT | ATT | SKIP |  |  |  |  |  |  |  |  |
| TITLE | ATT | SKIP |  |  |  |  |  |  |  |  |
| UNIT_MULT | ATT | CELL | H8/2 |  |  |  |  |  |  |  |
| PRE_BREAK_VALUE | ATT | SKIP |  |  |  |  |  |  |  |  |
| DATA_COMP | ATT | SKIP |  |  |  |  |  |  |  |  |
| CURRENCY | ATT | SKIP |  |  |  |  |  |  |  |  |
| MEASURE2 1 | MES | OBS_LEVEL | 2 | ** ** | ** ** | ** ** | **2-2** |  |  |  |
| MEASURE2 2 | MES | CELL | AE1 | ** ** | ** ** | ** ** | **2-2** |  |  |  |

> <span id="_Toc495078262" class="anchor"></span>**ANNEX O: Supported
> Conversion**

<table>
<colgroup>
<col style="width: 8%" />
<col style="width: 4%" />
<col style="width: 7%" />
<col style="width: 7%" />
<col style="width: 8%" />
<col style="width: 8%" />
<col style="width: 7%" />
<col style="width: 11%" />
<col style="width: 8%" />
<col style="width: 10%" />
<col style="width: 11%" />
<col style="width: 7%" />
</colgroup>
<tbody>
<tr>
<td style="text-align: right;"><p><strong>Input</strong></p>
<p><strong>Output</strong></p></td>
<td style="text-align: center;"><strong>CSV</strong></td>
<td style="text-align: center;"><p><strong>SDMX</strong></p>
<p><strong>CSV</strong></p></td>
<td style="text-align: center;"><strong>GESMESTS</strong></td>
<td style="text-align: center;"><strong>SDMX GENERIC</strong></td>
<td style="text-align: center;"><strong>SDMX COMPACT</strong></td>
<td style="text-align: center;"><strong>SMDX UTILITY</strong></td>
<td style="text-align: center;"><strong>SDMX CROSS
SECTIONAL</strong></td>
<td style="text-align: center;"><strong>EXCEL</strong></td>
<td style="text-align: center;"><strong>SDMX 2.1 (*****)</strong></td>
<td style="text-align: center;"><strong>Message Group
(******)</strong></td>
<td style="text-align: center;"><strong>FLR</strong></td>
</tr>
<tr>
<td style="text-align: right;">CSV (**)</td>
<td style="text-align: center;">NO</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES(*)</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
</tr>
<tr>
<td style="text-align: right;">SDMX CSV</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">NO</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
</tr>
<tr>
<td style="text-align: right;">GESMES/TS</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">NO</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES(*)</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">NO</td>
<td style="text-align: center;">NO</td>
</tr>
<tr>
<td style="text-align: right;">SDMX GENERIC</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">NO</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES(*)</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">NO</td>
<td style="text-align: center;">YES</td>
</tr>
<tr>
<td style="text-align: right;">SDMX COMPACT</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">NO</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES(*)</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">NO</td>
<td style="text-align: center;">YES</td>
</tr>
<tr>
<td style="text-align: right;">SMDX UTILITY</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">NO</td>
<td style="text-align: center;">YES(*)</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">NO</td>
<td style="text-align: center;">YES</td>
</tr>
<tr>
<td style="text-align: right;">SDMX CROSS-SECTIONAL</td>
<td style="text-align: center;"><p>YES</p>
<p>(*)</p></td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;"><p>YES</p>
<p>(*)</p></td>
<td style="text-align: center;"><p>YES</p>
<p>(*)</p></td>
<td style="text-align: center;"><p>YES</p>
<p>(*)</p></td>
<td style="text-align: center;"><p>YES</p>
<p>(*)</p></td>
<td style="text-align: center;">NO</td>
<td style="text-align: center;">NO</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">NO</td>
<td style="text-align: center;">YES</td>
</tr>
<tr>
<td style="text-align: right;">SDMX 2.1</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;"><p>YES</p>
<p>(****)</p></td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">NO</td>
<td style="text-align: center;">NO</td>
<td style="text-align: center;">YES</td>
</tr>
<tr>
<td style="text-align: right;">EXCEL</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">NO</td>
<td style="text-align: center;">NO</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">NO</td>
<td style="text-align: center;">YES</td>
</tr>
<tr>
<td style="text-align: right;">FLR</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">NO</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">NO</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">YES</td>
<td style="text-align: center;">NO</td>
</tr>
</tbody>
</table>

> (\*) The selected DSD for these files must support cross-sectional
> messages i.e. having defined cross-sectional measures and
> cross-sectional attachment levels for its components (see SDMX
> standard [<u>www.sdmx.org</u>](http://www.sdmx.org/))
>
> (\*\*)When the output format (CSV) is a flat file the attributes,
> attached in higher level than observations in the input message are
> omitted.
>
> (\*\*\*\*)The provided DSD has to be valid with Time dimension or
> cross sectional measures.
>
> (\*\*\*\*\*)With exception of SDMX V2.1 formats no other format
> supports multiple datasets in a single data message. Consequently
> Converter only supports conversions of SDMX V2.1 files having a single
> dataset per message. Also conversion from SDMX 2.1 to SDMX 2.0 formats
> is possible only when the DSD is compatible with both formats. The
> compatibility with V2.0 formats is checked in SDMX Source API before
> conversion begins.
>
> (\*\*\*\*\*\*)The Message Group input file should have only one
> dataset reported in the message.
>
> <span id="_Toc495078263" class="anchor"></span>**Annex P – Structure
> of a SDMX CSV file**

For SDMX_CSV version 1.0 file header row is mandatory and the order of
concepts and attributes is expected to be the one from the Data
Structure but grouped by type as the following: *dimensions, time,
observation value, observation level attributes, other attributes.*. The
first column is the Dataflow Id (Agency:Id:Version). See an example
below:

DATAFLOW;TABLE_IDENTIFIER;FREQ;REF_AREA;REF_SECTOR;EDU_TYPE;ISC11P_LEVEL;ISC11P_CAT;ISC11P_SUB;GRADE;FIELD;INTENSITY;COUNTRY_ORIGIN;COUNTRY_CITIZENSHIP;SEX;AGE;STAT_UNIT;UNIT_MEASURE;TIME_PERIOD;OBS_VALUE;OBS_STATUS;COMMENT_OBS;TIME_PER_COLLECT;ORIGIN_CRITERION;REF_YEAR_AGES;REF_PER_START;REF_PER_END;COMPILING_ORG;DECIMALS;UNIT_MULT

ESTAT:SSTSCONS_PROD_DT_A(1.0);PERS1;A;MT;INST_PRIV_GOV;\_T;L5T8;C4;\_T;\_T;\_T;PT;W0;W0;\_T;\_T;STU;PER;2013;NaN;;;2014-07-01;\_Z;2013-01-01;2012-09-22;2013-06-15;\_T;0;0

ESTAT:SSTSCONS_PROD_DT_A(1.0);PERS2;A;MT;INST_PRIV;\_T;L2;\_T;\_T;\_T;\_T;\_T;W0;W0;\_T;\_T;TEACH;PER;2013;NaN;;;2014-07-01;\_Z;2013-01-01;2012-09-22;2013-06-15;\_T;0;0

ESTAT:SSTSCONS_PROD_DT_A(1.0);PERS4;A;MT;INST_T;\_T;L1;\_T;\_T;\_T;\_T;FT;W0;W0;M;\_T;AIDE;PER;2013;NaN;;;2014-07-01;\_Z;2013-01-01;2012-09-22;2013-06-15;\_T;0;0

ESTAT:SSTSCONS_PROD_DT_A(1.0);PERS1;A;MT;INST_PRIV_IND;\_T;L5T8;C4;\_T;\_T;\_T;FT;W0;W0;\_T;\_T;STU;PER;2013;NaN;;;2014-07-01;\_Z;2013-01-01;2012-09-22;2013-06-15;\_T;0;0

ESTAT:SSTSCONS_PROD_DT_A(1.0);PERS1;A;MT;INST_PRIV;\_T;L4;C5;\_T;\_T;\_T;\_T;W0;W0;\_T;\_T;STU;PER;2013;NaN;;;2014-07-01;\_Z;2013-01-01;2012-09-22;2013-06-15;\_T;0;0

ESTAT:SSTSCONS_PROD_DT_A(1.0);PERS2;A;MT;INST_PRIV;\_T;L4;C4;\_T;\_T;\_T;PT;W0;W0;M;\_T;TEACH;PER;2013;NaN;;;2014-07-01;\_Z;2013-01-01;2012-09-22;2013-06-15;\_T;0;0

ESTAT:SSTSCONS_PROD_DT_A(1.0);PERS2;A;MT;INST_PUB;\_T;L5T8;\_T;\_T;\_T;\_T;FT;W0;W0;F;\_T;TEACH;PER;2013;NaN;;;2014-07-01;\_Z;2013-01-01;2012-09-22;2013-06-15;\_T;0;0

ESTAT:SSTSCONS_PROD_DT_A(1.0);PERS4;A;MT;INST_T;\_T;L0;C2;\_T;\_T;\_T;FT;W0;W0;\_T;\_T;MAN;PER;2013;NaN;;;2014-07-01;\_Z;2013-01-01;2012-09-22;2013-06-15;\_T;0;0

ESTAT:SSTSCONS_PROD_DT_A(1.0);PERS3;A;MT;INST_T;\_T;L0;\_T;\_T;\_T;\_T;\_T;W0;W0;\_T;\_U;TEACH;PER;2013;NaN;;;2014-07-01;\_Z;2013-01-01;2012-09-22;2013-06-15;\_T;0;0

ESTAT:SSTSCONS_PROD_DT_A(1.0);PERS3;A;MT;INST_T;\_T;L3;\_T;\_T;\_T;\_T;\_T;W0;W0;F;Y_GE65;TEACH;PER;2013;NaN;;;2014-07-01;\_Z;2013-01-01;2012-09-22;2013-06-15;\_T;0;0

ESTAT:SSTSCONS_PROD_DT_A(1.0);PERS1;A;MT;INST_PUB;\_T;L3;C4;\_T;\_T;\_T;\_T;W0;W0;\_T;\_T;STU;PER;2013;NaN;;;2014-07-01;\_Z;2013-01-01;2012-09-22;2013-06-15;\_T;0;0

For SDMX_CSV version 2.0 which is an SDMX_CSV accomodating SDMX 3.0.
Header row is again mandatory and the first three columns are always
STRUCTURE\[;\], STRUCTURE_ID, ACTION.

STRUCTURE\[;\],STRUCTURE_ID,ACTION,OBS_VALUE1,OBS_VALUE2,ATTR_3,ATTR_1\[\],DIM_2,DIM_1,DIM_3

dataflow,ESTAT:NA_MAIN(1.6.0),I,12.4,12.5,"Normal, special and other
values",X;Y,B,A,2014-01

dataflow,ESTAT:NA_MAIN(1.6.0),I,10.8,10.9,"Normal, special and other
values",X;Z,B,A,2014-02

> <span id="_Toc495078264" class="anchor"></span>**Annex R: Examples of
> Validation Requests for Web Service**

**sample soap request with structure in registry**

\<soapenv:Envelope
xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
xmlns:v3="http://xmlns.ec.eu/BusinessActivityService/StruvalBAS/V3"
xmlns:v31="http://xmlns.ec.eu/BusinessObjects/StruvalDS/V3/"\>

\<soapenv:Header/\>

\<soapenv:Body\>

\<v3:ValidateData\>

\<Input type=”SDMX_ML”\>

\<V31:InputFile\><u>cid:input</u>\</V31:InputFile\>

\</Input\>

\<StructureConfig\>

\<v31:Registry url="http://registry.org/rest" agency="ESTAT"
id="UOE_NON_FINANCE" version="1.0" type=”REST_V1”/\>

\</StructureConfig\>

\<MaximumErrorNumber\>1\</MaximumErrorNumber\>

\</v3:ValidateData\>

\</soapenv:Body\>

\</soapenv:Envelope\>

**sample soap request with structure in file and minumum configuration**

\<soapenv:Body\>

\<v3:ValidateData\>

\<Input\>

\<V31:InputFile\><u>cid:input</u>\</V31:InputFile\>

\</Input\>

\<StructureConfig\>

\<V31:Structure\>

\<V31:StructureFile\>[<u>cid:structure</u>](cid:structure)\</V31:StructureFile\>

\</V31:Structure\>

\</StructureConfig\>

\<MaximumErrorNumber\>1\</MaximumErrorNumber\>

\</v3:ValidateData\>

\</soapenv:Body\>

**sample soap request with structure in file and all non-mandatory
attributes used**

\<soapenv:Body\>

\<v3:ValidateData\>

\<Input\>

\<V31:InputFile\><u>cid:input</u>\</V31:InputFile\>

\</Input\>

\<StructureConfig\>

\<V31:Structure agency="ESTAT" id="UOE_NON_FINANCE" version="1.0"\>

\<V31:StructureFile\>[<u>cid:structure</u>](cid:structure)\</V31:StructureFile\>

\</V31:Structure\>

\</StructureConfig\>

\<MaximumErrorNumber\>10\</MaximumErrorNumber\>

\</v3:ValidateData\>

\</soapenv:Body\>

**sample Soap request for SDMX CSV validation**

\<soapenv:Body\>

\<v3:ValidateData\>

\<Input type=”SDMX_CSV”\>

\<v31:InputFile\><u>cid:input</u>\</v31:InputFile\>

\<v31:InputConfig\>

\<v31:Config type="parameters"\>

\<v31:configFile\> <u>cid:properties</u> \<v31:configFile/\>

\</v31:Config\>

\</v31:InputConfig\>

\</Input\>

\<StructureConfig\>

\<v31:Structure agency="ESTAT" id="UOE_NON_FINANCE" version="1.0"\>

\<v31:StructureFile\><u>cid:structure</u> \</v31:StructureFile\>

\<Structure\>

\</StructureConfig\>

\<MaximumErrorNumber\>1\</MaximumErrorNumber\>

\</v3:ValidateData\>

\</soapenv:Body\>

**sample Soap request for MULTI_LEVEL_CSV validation with transcoding**

\<soapenv:Body\>

\<v3:ValidateData\>

\<Input\>

\< v31:InputFile type=” MULTI_LEVEL_CSV”\><u>cid:input</u>\</
v31:InputFile\>

\< v31:InputConfig\>

\< v31:Config type="parameters"\>

\< v31:configFile\><u>cid:properties</u> \</v31:configFile/\>

\</ v31:Config\>

\< v31:Config type=”mapping”\>

\< v31:configFile\><u>cid:mapping</u>\</v31:configFile\>

\</ v31:Config\>

\< v31:Config type=”transcoding”\>

\< v31:configFile\><u>cid:transcodin</u>\</v31:configFile\>

\</ v31:Config\>

\</ v31:InputConfig\>

\</Input\>

\<StructureConfig\>

\< v31:Structure agency="ESTAT" id="UOE_NON_FINANCE" version="1.0"\>

\< v31:StructureFile\><u>cid:structure</u>\</ v31:StructureFile\>

\</ v31:Structure\>

\</StructureConfig\>

\<MaximumErrorNumber\>1\</MaximumErrorNumber\>

\</v3:ValidateData\>

\</soapenv:Body\>

> <span id="_Toc46407951" class="anchor"></span>**Annex S – Struval
> Error Messages**

<table>
<colgroup>
<col style="width: 5%" />
<col style="width: 6%" />
<col style="width: 22%" />
<col style="width: 39%" />
<col style="width: 25%" />
</colgroup>
<thead>
<tr>
<th style="text-align: center;"><strong>Error Code</strong></th>
<th style="text-align: center;"><strong>Message Code</strong></th>
<th style="text-align: center;"><strong>MessageText</strong></th>
<th style="text-align: center;"><strong>Error Details</strong></th>
<th style="text-align: center;"><strong>Comments</strong></th>
</tr>
</thead>
<tbody>
<tr>
<td style="text-align: right;">500</td>
<td>Null</td>
<td>Internal server error. Validation service not available.</td>
<td>The STRUVAL service is not able to process the input as the file is
not in the expected format or is corrupted</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">140</td>
<td>Null</td>
<td>&lt;Message from XML Parser&gt;</td>
<td>The SDMX-ML file is not a well-formed XML file. It may contain such
errors as invalid characters, tags that are not closed or are closed out
of order. Well formedness of an XML file can be checked using different
tools, such as the advanced text editors or online</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">003</td>
<td>The dataset contains a series with a missing mandatory concept
{0}</td>
<td>The data file contains series with uncomplete key, a dimension or
mandatory attribute is missing</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">004</td>
<td>The DSD {0} used does not define a time dimension, required for the
time series data.</td>
<td>When building a time-series dataset, one must use a DSD that
includes a time dimension</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">005</td>
<td>The DSD is missing a primary measure, this is required for time
series data : {0}</td>
<td>When building a time-series dataset, one must use a DSD that has a
primary measure</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">904-1</td>
<td>Series key {0} is not defined in DSD.</td>
<td>Dataset contains series keys which unexpected size</td>
<td>Replaced by other validations (like missing concept 031 or some
other code depending on the specific case because the size of the series
keys may be higher or lower than expected size)</td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">904-2</td>
<td>Series key {0} is not defined in DSD (incorrect codes).</td>
<td>Dataset contains series keys which unexpected size.</td>
<td>Replaced by 029 and the error is found when the code of the concept
is incorrect.</td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">007</td>
<td>The dataset contains a concept {0} that is not defined in DSD.</td>
<td>All concepts used in a dataset must be defined in a DSD</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">008</td>
<td>Attribute {0} defined as mandatory in DSD is missing from the
dataset.</td>
<td>The dataset contains a mandatory series level attribute which is not
present in the data file</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">009</td>
<td>Series attribute {0} is not defined in DSD.</td>
<td>The encountered attribute at the series level in data file does not
exist in Data Structure</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">010</td>
<td>Attribute {0} defined as mandatory in DSD is missing from the
group.</td>
<td>The dataset contains a mandatory group level attribute which is not
present in the data file</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">011</td>
<td>Attribute {0} is assigned to the incorrect group.</td>
<td>The encountered attribute at the dataset level in data file does not
exist in Data Structure</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">012</td>
<td>Attribute {0} defined as mandatory in DSD is missing from the
observation.</td>
<td>The dataset contains a mandatory observation level attribute which
is not present in the data file</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">013</td>
<td>Attribute {0} is not defined in DSD for observation.</td>
<td>The encountered observation attribute is not defined by Data
Structure.</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">014</td>
<td>Dataset group {0} is not defined in the DSD.</td>
<td>Dataset contains group keys which unexpected size</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">015</td>
<td>Dataset group {0} is not defined in the DSD.</td>
<td>Data Structure Definition does not define a Group with id '%s'</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">016</td>
<td>The mandatory concept {0} in DSD is currently missing from the
group.</td>
<td>The dataset contains a group which does not have all mandatory
concepts defined in the DSD</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">017</td>
<td>Concept {0} is assigned to the incorrect group.</td>
<td>The encountered group in the dataset contains a concept which is not
defined in the DSD</td>
<td>Replaced by 011 and “Xml unexpected attribute”<a href="#fn1"
class="footnote-ref" id="fnref1"
role="doc-noteref"><sup>1</sup></a></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">018</td>
<td>XML error - The dataset contains an invalid node.</td>
<td>Appears when an unexpected node exists in the dataset file</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">019</td>
<td>Flat dataSet expected, (dimension At Observation is 'All
Dimensions') but Series element encountered. Flat dataSets contain only
Obs elements</td>
<td>A flat dataset is a dataset that consists of observations, which are
not grouped in series. Each observation gives values for all dimensions
("all dimensions are under observation"). It is an error to have a
series element in a flat dataset</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">020</td>
<td>Non flat dataSet expected, (dimension At Observation is not 'All
Dimensions') but flat dataset encountered. Flat dataSets contain only
Obs elements</td>
<td>A flat dataset is a dataset that consists of observations, which are
not grouped in series. Each observation gives values for all dimensions
("all dimensions are under observation"). It is an error to have a
series element in a flat dataset</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">021</td>
<td>XML error - Unexpected text "{0}" found at node "{1}"</td>
<td>Unexpected text is found as children of one sdmx node which does not
contains text. Sdmx node names are kept in an internal structure and has
the names like: Header, Series, Obs, Group etc. This error message
appear when the dataset contains as children of these elements</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">022</td>
<td>XML error - Dataset header fails to reference a provision agreement,
dataflow, or DSD.</td>
<td>Dataset header fails to reference a provision agreement, a dataflow,
or a data structure definition</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">023</td>
<td>XML error - Dataset does not contain a header.</td>
<td>Dataset does not contain a header</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">024</td>
<td>XML error - Dataset structure reference incomplete.</td>
<td>The message appears if the referenced structure is incomplete, i.e.
the agencyId, id or maintainableParentId are missing or empty</td>
<td>Replaced by 022 validation (which was not implemented from the
beginning)</td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">025</td>
<td>XML error - Invalid DSD reference.</td>
<td>Dataset structure reference invalid, could not process reference, no
Ref node or URN node found</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">026</td>
<td>Attribute {0} is not defined in DSD.</td>
<td>An attribute at dataset level is present in data file but it is not
defined in the DSD.</td>
<td>Replaced by 009 and 011 (depending on the case) and “Xml undefined
attribute” <a href="#fn2" class="footnote-ref" id="fnref2"
role="doc-noteref"><sup>2</sup></a></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">027</td>
<td>Expected component {0} must be an attribute, but is {1}.</td>
<td>Another component appears as a dataset attribute in data file.</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">028</td>
<td>Attribute {0} incorrectly attached to {2} instead of to {1}.</td>
<td>The dataset has an attribute with different attachment level.</td>
<td>Replaced by the errors 009 or 011.</td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">029</td>
<td>{0} ''{1}'' is reporting value ''{2}'' which is not a valid
representation in referenced codelist ''{3}''.</td>
<td>An attribute at dataset, series or observation level has a value
which is not valid in the referenced codelist.</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">030</td>
<td>{0} {1} is reporting invalid value "{2}" which{3}.</td>
<td>Appears when reported value of a concept is unexpected.</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">031</td>
<td>Component {0} in group {1} not defined in DSD {2}.</td>
<td>The dataset contains groups which contains components that are not
defined as group components in the DSD.</td>
<td>Replaced by 011 and “Xml unexpected attribute”<a href="#fn3"
class="footnote-ref" id="fnref3"
role="doc-noteref"><sup>3</sup></a></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">032</td>
<td>The observation does not have a value for its time dimension (i.e.
the reference period is missing).</td>
<td>Observation missing time dimension for time series data.</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">033</td>
<td>Observations not allowed for this dataset.</td>
<td>Appears if there is a constraint on the dataset which does not allow
observations.</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">034</td>
<td>Observation time ''{0}'' is before the expected reporting period
start date "{1}".</td>
<td>Appears if there is a constraint which specify report start date and
the observation time is before this date.</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">035</td>
<td>Observation Time ''{0}'' is after the expected reporting period end
date "{1}".</td>
<td>Appears if there is a constraint which specify report end date and
the observation time is after this date.</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">036</td>
<td>Series not allowed in this dataset.</td>
<td>Appears if there is a constraint on the dataset which does not allow
series.</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">037</td>
<td>Series key {0} not allowed.</td>
<td>Appears if the dimension is not allowed in the key due to an
existing constraint</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">038</td>
<td>Illegal Series key {0} contains invalid value "{1}" not defined in
DSD for {2} {3}.</td>
<td>Appears when the series key contains some value which is disallowed
by included constraints</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">039</td>
<td>Duplicate observation found</td>
<td>Appears when more than one observation are found in one series.</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">040</td>
<td>Data validation failed : {0}</td>
<td><p>It appears when a custom validation rule does not pass.</p>
<p>Data validation failed :
Failure("checkDataSetAttributeValue")</p></td>
<td>Error never occurs</td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">041</td>
<td>Cross-sectional component {0} is incorrectly attached to {2} instead
of to {1}.</td>
<td>The cross-sectional component is attached to a wrong level.</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">042</td>
<td>Invalid date format "{0}".</td>
<td>Appears if the TIME_PERIOD attribute does not match the
TIME_FORMAT.</td>
<td>Validation left for a future release. (see SDMXCONV-310).</td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">043</td>
<td>Structure type wrongly references {1} instead of {0}.</td>
<td>If the dataset header contains a URN reference to other artefact
then expected.</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">100</td>
<td style="text-align: right;">044</td>
<td>The dataset references dataflow “{0}” which could not be
resolved.</td>
<td>The structure file supplied to the STRUVAL service call does not
contain a dataflow (identified by agency, name, and version) that is
referenced from the dataset.</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">100</td>
<td style="text-align: right;">045</td>
<td>The dataset references DSD “{0}” which could not be resolved.</td>
<td>The structure file supplied to the STRUVAL service call does not
contain a DSD (identified by agency, name, and version) that is
referenced from the dataset.</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">501</td>
<td style="text-align: right;">046</td>
<td>Component attribute {0} with parent {1} not supported.</td>
<td>When an XML attribute is in the wrong element.</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">501</td>
<td style="text-align: right;">047</td>
<td>Cannot read dataset for structure of type: '{0}'</td>
<td>If the dataset has a structure reference which is neither DSD or
Dataflow</td>
<td>The message is not testable in Converter applications because we
don't support structures other than DSD and Dataflows. This error
message appears only if struval is used as API.</td>
</tr>
<tr>
<td style="text-align: right;">501</td>
<td style="text-align: right;">048</td>
<td>The DSD {0} is missing a time dimension.</td>
<td>DSDs that STRUVAL can process must contain a time dimension.</td>
<td>The error message 501 - 048 - "The DSD {0} is missing a time
dimension" is in conflict with 150 - 004 - "The DSD {0} used does not
define a time dimension, required for the time series data". They both
refer to the same thing, the first was created by Intrasoft ( hence the
4 digits message code) in order to cover some bugs in SdmxSource ( see
<a
href="https://webgate.ec.europa.eu/CITnet/jira/browse/SDMXSOURCE-10"><u>SDMXSOURCE-10</u></a>)
whereas the 004 is thrown by Sdmx Source (so it's standard). Starting
with Converter 6.9.1 the first one (9946) is no longer used.</td>
</tr>
<tr>
<td style="text-align: right;">501</td>
<td style="text-align: right;">049</td>
<td>Cannot validate the header of format {0}.</td>
<td>Appears when the struval tries to validate a header but the given
dataset file is not detected as been one of the following formats:
COMPACT_2_0,GENERIC_2_0,CROSS_SECTIONAL_2_0, UTILITY_2_0,
GENERIC_2_1,GENERIC_2_1_XS,COMPACT_2_1 or COMPACT_2_1_XS</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">050</td>
<td>Property not found {0}</td>
<td>Appears when the validation fails, because of missing input or
structure file</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">140</td>
<td style="text-align: right;">051</td>
<td>Configuration Error {0}</td>
<td>Appears when Excel Data Reader was not configured correctly</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">140</td>
<td style="text-align: right;">052</td>
<td>Data reader error. {0}.</td>
<td>Appears when Reading the input file was not possible</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">140</td>
<td style="text-align: right;">053</td>
<td>Data reader</td>
<td>The Dataset requires an embedded or external Parameters sheet to
process the data.</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">054</td>
<td>Error While Processing XML : {0}</td>
<td>Appears when XML structure validation fails</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">055</td>
<td>Structure Fails Validation: {0}</td>
<td>Appears when parameters validation fails</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">056</td>
<td>I/O exception: {0}</td>
<td>Appears when a file either does not exist or could not be
recognised.</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">057</td>
<td>Unsupported {0}</td>
<td>Indicates that the requested operation is not supported.</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">058</td>
<td>Referenced structure could not be resolved {0}</td>
<td>Structure not found.</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">059</td>
<td>null</td>
<td>General request error check your request files and parameters.</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">060</td>
<td>The dataset contains a header row with a missing mandatory {0}:
{1}.</td>
<td>The input file is an empty Csv file and a dimension or mandatory
attribute is missing from the header row.</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">061</td>
<td>Data reader error</td>
<td>Appears when Reading the input file was not possible. {0}.</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">062</td>
<td>{0} {1} value contains invalid character.</td>
<td>Appears when an invalid character was detected in a component
value.</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">063</td>
<td>{0} ''{1}'' is reporting invalid value which{2}</td>
<td>Appears when reported value of a concept is unexpected</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">064</td>
<td>Illegal Series key {0} contains an invalid value not defined in DSD
for {1} ''{2}''</td>
<td>Appears when the series key contains some value which is disallowed
by included constraints</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">065</td>
<td>Duplicate columns/concepts found in Header Row: {0}</td>
<td>Appears when the header row in a CSV file contains duplicate
concepts/columns</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">066</td>
<td>Attribute {0} has less instances than minimum occurrences defined by
Data Structure.</td>
<td>Appears when the attribute has less occurrences than from what it is
defined by DSD or Dataflow</td>
<td></td>
</tr>
<tr>
<td style="text-align: right;">150</td>
<td style="text-align: right;">067</td>
<td>Attribute {0} has more instances than maximum occurrences defined by
Data Structure.</td>
<td>Appears when the attribute has less occurrences than from what it is
defined by DSD or Dataflow</td>
<td></td>
</tr>
</tbody>
</table>
<section id="footnotes" class="footnotes footnotes-end-of-document"
role="doc-endnotes">
<hr />
<ol>
<li id="fn1"><p>“Xml unexpected attribute” is shown only when the SDMX
attribute is also an xml attribute.<a href="#fnref1"
class="footnote-back" role="doc-backlink">↩︎</a></p></li>
<li id="fn2"><p>“Xml undefined attribute” appears only when the sdmx
attribute is also an xml attribute.<a href="#fnref2"
class="footnote-back" role="doc-backlink">↩︎</a></p></li>
<li id="fn3"><p>“xml unexpected attribute” appears only when the sdmx
component is also a xml attribute.<a href="#fnref3"
class="footnote-back" role="doc-backlink">↩︎</a></p></li>
</ol>
</section>

**  **

> <span id="_Toc46407952" class="anchor"></span>**Annex T – Instructions
> to Access Registry over HTTPS**

Being able to use the registry from some sites for rest/wsdl requests
from Java they needed to have a certificate added in java trust store.
Trying to access it from SDMX Converter web service for example triggers
an error like (in logs): *javax.net.ssl.SSLHandshakeException:
sun.security.validator.ValidatorException: PKIX path building failed:
sun.security.provider.certpath.SunCertPathBuilderException: unable to
find valid certification path to requested targett
sun.security.ssl.Alerts.getSSLException..*

The error appears because whenever Java attempts to connect to another
application over SSL (e.g.: HTTPS, IMAPS, LDAPS), it will only be able
to connect to that application if it can trust it. The way trust is
handled in the Java world is that you have a keystore (typically
$JAVA_HOME/lib/security/cacerts), also known as the truststore. This
contains a list of all known Certificate Authority (CA) certificates,
and Java will only trust certificates that are signed by one of those
CAs or public certificates that exist within that keystore.

<span id="_Toc46407953" class="anchor"></span>**Obtain your own
certificate**

To obtain the certificate please follow the steps provided in the
attached word document. Please contact us if you have any questions.

We expect that details to be provided by the Registry that needs this
but a method to obtain the certificate and put it in trust store java is
presented in the following steps:

**Step 1**: For you to view the SSL certificate details please open the
URL
[<u>https://registry.sdmx.org/FusionRegistry/ws/rest</u>](https://registry.sdmx.org/FusionRegistry/ws/rest)
with Google Chrome and go to the Three Dots Menu -\> More Tools -\>
Developer Tools.
<img src="media/image47.jpg" style="width:7.02199in;height:3.79167in"
alt="A screenshot of a computer Description automatically generated" />

**Step 2**: Click on the Security Tab. This will give you a Security
Overview with a View Certificate Button.

<img src="media/image48.jpg" style="width:7.01042in;height:3.79282in"
alt="A screenshot of a computer Description automatically generated" />

**Step 3**: In the certificate window click Certification Path-\>Select
the ROOT-\> View Certificate-\> Copy to File for the Certificate Export
Wizard, and click Next. Select DER encode binary X.509 (.CER) option,
select a name and a path, for example (C:\Users\ioan\Desktop\ca.cer),
click Next and Finish to save.

<img src="media/image49.jpg" style="width:6.5in;height:3.46597in"
alt="A screenshot of a computer Description automatically generated" />

**Step 4**: In the command line. Convert the root certificate to DER
format. This can be done with help of the **openssl** toolkit, where
ca.cer is the original certificate filename in PEM format, and ca.der
the filename to output, in DER format (which the Java keytool utility
can understand). If you were able to obtain the root certificate in DER
format, skip this step:

openssl x509 -in ca.pem -inform pem -out ca.der -outform der

**Step 5**: Validate the root certificate content. Ensure that the Java
keytool can parse the certificate and display its content, with the
following cmd command:

keytool -v -printcert -file ca.der

**Step 6**: Import the root certificate into the JVM trust store, with
the following command:

keytool -importcert -alias startssl -keystore “C:\Program
Files\Java\jdk-11\lib\security\cacerts” -storepass changeit -file ca.der

(the default password for the CA store is changeit)

The keytool will prompt you for confirmation, enter yes to complete the
operation.

**Step 7**: Verify that the root certificate has been imported with the
command:

keytool -list -v -keystore “C:\Program
Files\Java\jdk-11\lib\security\cacerts” -alias startssl

**Step 8**: Restart JVM/PC

<span id="_Toc46407954" class="anchor"></span>**Use an existing
certificate**

You can define a certificate to be loaded from the application that
contains all the necessary certificates for the connection with
registry. Inside the properties file (configuration file) you can set
the path for the file to be used. The settings for configuring the
certificate to be used when connecting to the registry service are the
following:

- registry.jks.path=

- registry.jks.password=changeit

The setting *registry.jks.path* is set with the path of the jks/cacerts
file to be used. If this setting is empty, the default keystore from the
project resources is used (cacerts). The setting *registry.jks.password*
is for setting the password for the keystore.

> <span id="_Toc46407955" class="anchor"></span>**Annex U – Reporting
> Period for SDMX 2.1 Output Formats**

With SDMX 2.1 the time periods can be provided in relation to a
reporting year. Saying that Reporting Period. If Reporting Period is
used then it will be as an attribute of DataSet under name
REPORTING_START_YEAR_DAY of format **--mm-dd**. For example --03-01
means that the reporting year starts with first of March. Then when a
Time Period is provided e.g. 2013-M02 it means it is the second month of
the Reporting Year, in this case the Gregorian Period would be 2013-04
(first month is between 1<sup>st</sup> of March and 1<sup>st</sup>
April, second month is between 1<sup>st</sup> April and 1<sup>st</sup>
of May, hence the Gregorian Time is April with TIME_FORMAT P1M).

The following cases exist:

- Conversion from a format without Reporting Period to SDMX 2.1 without
  using the Reporting Period then the same Gregorian Time remains with
  no action needed from the user

- Conversion from an SDMX 2.1 without Reporting Period also needs no
  action from the user

- Conversion to SDMX 2.1 when a Reporting Period is needed. In this case
  the REPORTING_START_YEAR_DAY must be specified otherwise the default
  is --01-01. The TIME_PERIOD from the input value is transformed
  accordingly to the REPORTING_START_YEAR_DAY.

> For example, when Gregorian Time Period is 2010-03 and the user wants
> the output file to be expressed reporting it to the Reporting Year and
> provides REPORTING_START_YEAR_DAY= --05-01 then the Time Period in the
> output file will be calculated starting with the previous year
> 2009-05-01 meaning **2010-M10** (the Gregorian time 2010-03 is the
> tenth month from the beginning of the reporting year day).

- Conversion from an SDMX 2.1 with Reporting Period to a format that
  does not need a Reporting Period (it can also be another SDMX 2.1
  format). The starting from REPORTING_START_YEAR_DAY and TIME_PERIOD in
  the input, the Gregorian time is calculated. E.g.
  REPORTING_START_YEAR_DAY= --05-01 TIME_PERIOD = **2010-M10**, in input
  file then it will be 2010-03 in output file (the Reporting Period Year
  is considered previous year).

<span id="_Annex_V:_The" class="anchor"></span>**Annex V: The structure
of a transcoding sheet for Excel parsing**

The Transcoding sheet inside an Excel must have the following structure:

| Text      | Dimension    | Value     |
|-----------|--------------|-----------|
| something | STS_ACTIVITY | New Value |
| nothing   | STS_ACTIVITY | N100CO    |
| cool      | STS_ACTIVITY | N100CO    |
| ble       | ADJUSTMENT   | W         |

The name of a Transoding sheet must start from “Trans” and the first row
must have the headers as appear above for the converter to pare it
correctly.

<span id="_Toc46407957" class="anchor"></span>**Annex W: The structure
of a properties file**

The following parameters are used in the properties files for csv, multi
level csv and sdmx csv validation.

csv.delimiter=;

csv.level=1

csv. headerrow=NO_COLUMN_HEADERS

csv.quotecharacter=”

errorIfEmpty=true

default.validation.inlineReportFormat=true

The following parameters are used in the properties files for flr.

flr. headerrow=NO_COLUMN_HEADERS

flr.expilicitmeasures=true

default.validation.inlineReportFormat=true

errorIfEmpty=true

flr.padding=TAB

The following parameter are used in the properties file for xml files:

default.validation.inlineReportFormat=true

errorIfEmpty=true

The following parameter is used in the properties file for excel files:

errorIfEmpty=true

The following parameter is used in the properties file of
Converter-Webapp only. It concerns the default timeout in the process of
uploading input files, expressed in seconds. The default timeout is set
to 180 seconds (3 minutes).

default.webapp.input.timeout=180

<span id="_Toc46407958" class="anchor"></span>**Annex X: Internal SDMX
CSV format**

Any format could be converted to internal SDMX CSV format. The iSDMX_CSV
is a format with metadata information about the input file data. The
additional information added differs from format to format. For example,
for XLS the cell of each observation is written as last column, for CSV
files only the row and for SDMX-ML the line and row of each observation.
Moreover, a column with the format of the input file is written.

The iSDMX_CSV file is the same with the SDMX_CSV except from the two
last columns and that the delimiter is semicolon as well as double
quotes are used by default.  
If in an iSDMX_CSV file there are new line, carriage return or end of
line characters the user has the option to remove(trim) those characters
by setting the default.iSdmxCsv.adjustment property of the configuration
file to true. Furthermore, if the input file contains semi-colon(‘;’)
within the value of an attribute this character gets transformed to
comma(‘,’). If the aforementioned property is set to false those special
characters remain in the output iSDMX_CSV file.

An example of an internal SDMX_CSV file is provided below:

![](media/image50.emf)

<span id="_Toc46407959" class="anchor"></span>**Annex Y: Character
Encoding**

The input files the user provides for Validation or Conversion should
have UTF-8 encoding.

Regarding the ASCII control characters from 0-30 only the 9,10 and 13
are allowed.

Every character from 32-255 are all allowed except 127.

ascii code 0 **NULL** (Null character)

ascii code 1 **SOH** (Start of Header)

ascii code 2 **STX** (Start of Text)

ascii code 3 **ETX** (End of Text)

ascii code 4 **EOT** (End of Transmission)

ascii code 5 **ENQ** (Enquiry)

ascii code 6 **ACK** (Acknowledgement)

ascii code 7 **BEL** (Bell)

ascii code 8 **BS** (Backspace)

ascii code 9 **HT** (Horizontal Tab)

ascii code 10 **LF** (Line feed)

ascii code 11 **VT** (Vertical Tab)

ascii code 12 **FF** (Form feed)

ascii code 13 **CR** (Carriage return)

ascii code 14 **SO** (Shift Out)

ascii code 15 **SI** (Shift In)

ascii code 16 **DLE** (Data link escape)

ascii code 17 **DC1** (Device control 1)

ascii code 18 **DC2** (Device control 2)

ascii code 19 **DC3** (Device control 3)

ascii code 20 **DC4** (Device control 4)

ascii code 21 **NAK** (Negative acknowledgement)

ascii code 22 **SYN** (Synchronous idle)

ascii code 23 **ETB** (End of transmission block)

ascii code 24 **CAN** (Cancel)

ascii code 25 **EM** (End of medium)

ascii code 26 **SUB** (Substitute)

ascii code 27 **ESC** (Escape)

ascii code 28 **FS** (File separator)

ascii code 29 **GS** (Group separator)

ascii code 30 **RS** (Record separator)

ascii code 31 **US** (Unit separator)

ascii code 32 (space)

ascii code 33 **!** (exclamation mark)

ascii code 34 **"** (Quotation mark)

ascii code 35 **\#** (Number sign)

ascii code 36 $ (Dollar sign)

ascii code 37 % (Percent sign)

ascii code 38 & (Ampersand)

ascii code 39 ' (Apostrophe)

ascii code 40 ( (round brackets or parentheses)

ascii code 41 ) (round brackets or parentheses)

ascii code 42 \* (Asterisk)

ascii code 43 + (Plus sign)

ascii code 44 , (Comma)

ascii code 45 - (Hyphen)

ascii code 46 . (Full stop , dot)

ascii code 47 / (Slash)

ascii code 48 0 (number zero)

ascii code 49 1 (number one)

ascii code 50 2 (number two)

ascii code 51 3 (number three)

ascii code 52 4 (number four)

ascii code 53 5 (number five)

ascii code 54 6 (number six)

ascii code 55 7 (number seven)

ascii code 56 8 (number eight)

ascii code 57 9 (number nine)

ascii code 58 : (Colon)

ascii code 59 ; (Semicolon)

ascii code 60 \< (Less-than sign )

ascii code 61 = (Equals sign)

ascii code 62 \> (Greater-than sign ; Inequality)

ascii code 63 ? (Question mark)

ascii code 64 @ (At sign)

ascii code 65 A (Capital A )

ascii code 66 B (Capital B )

ascii code 67 C (Capital C )

ascii code 68 D (Capital D )

ascii code 69 E (Capital E )

ascii code 70 F (Capital F )

ascii code 71 G (Capital G )

ascii code 72 H (Capital H )

ascii code 73 I (Capital I )

ascii code 74 J (Capital J )

ascii code 75 K (Capital K )

ascii code 76 L (Capital L )

ascii code 77 M (Capital M )

ascii code 78 N (Capital N )

ascii code 79 O (Capital O )

ascii code 80 P (Capital P )

ascii code 81 Q (Capital Q )

ascii code 82 R (Capital R )

ascii code 83 S (Capital S )

ascii code 84 T (Capital T )

ascii code 85 U (Capital U )

ascii code 86 V (Capital V )

ascii code 87 W (Capital W )

ascii code 88 X (Capital X )

ascii code 89 Y (Capital Y )

ascii code 90 Z (Capital Z )

ascii code 91 \[ (square brackets or box brackets)

ascii code 92 \\ (Backslash)

ascii code 93 \] (square brackets or box brackets)

ascii code 94 ^ (Caret or circumflex accent)

ascii code 95 \_ (underscore, under strike, underbar or low line)

ascii code 96 \` (Grave accent)

ascii code 97 a (Lowercase a )

ascii code 98 b (Lowercase b )

ascii code 99 c (Lowercase c )

ascii code 100 d (Lowercase d )

ascii code 101 e (Lowercase e )

ascii code 102 f (Lowercase f )

ascii code 103 g (Lowercase g )

ascii code 104 h (Lowercase h )

ascii code 105 **i** (Lowercase i )

ascii code 106 j (Lowercase j )

ascii code 107 k (Lowercase k )

ascii code 108 l (Lowercase l )

ascii code 109 m (Lowercase m )

ascii code 110 n (Lowercase n )

ascii code 111 o (Lowercase o )

ascii code 112 p (Lowercase p )

ascii code 113 q (Lowercase q )

ascii code 114 r (Lowercase r )

ascii code 115 s (Lowercase s )

ascii code 116 t (Lowercase t )

ascii code 117 u (Lowercase u )

ascii code 118 v (Lowercase v )

ascii code 119 w (Lowercase w )

ascii code 120 x (Lowercase x )

ascii code 121 y (Lowercase y )

ascii code 122 z (Lowercase z )

ascii code 123 { (curly brackets or braces)

ascii code 124 \| (vertical-bar, vbar, vertical line or vertical slash)

ascii code 125 } (curly brackets or braces)

ascii code 126 ~ (Tilde ; swung dash)

ascii code 127 DEL (Delete)

ascii code 128 Ç (Majuscule C-cedilla )

ascii code 129 ü (letter "u" with umlaut or diaeresis ; "u-umlaut")

ascii code 130 é (letter "e" with acute accent or "e-acute")

ascii code 131 â (letter "a" with circumflex accent or "a-circumflex")

ascii code 132 ä (letter "a" with umlaut or diaeresis ; "a-umlaut")

ascii code 133 à (letter "a" with grave accent)

ascii code 134 å (letter "a" with a ring)

ascii code 135 ç (Minuscule c-cedilla)

ascii code 136 ê (letter "e" with circumflex accent or "e-circumflex")

ascii code 137 ë (letter "e" with umlaut or diaeresis ; "e-umlaut")

ascii code 138 è (letter "e" with grave accent)

ascii code 139 ï (letter "i" with umlaut or diaeresis ; "i-umlaut")

ascii code 140 î (letter "i" with circumflex accent or "i-circumflex")

ascii code 141 ì (letter "i" with grave accent)

ascii code 142 Ä (letter "A" with umlaut or diaeresis ; "A-umlaut")

ascii code 143 Å (letter "A" with a ring)

ascii code 144 É (Capital letter "E" with acute accent or "E-acute")

ascii code 145 æ (Latin diphthong "ae")

ascii code 146 Æ (Latin diphthong "AE")

ascii code 147 ô (letter "o" with circumflex accent or "o-circumflex")

ascii code 148 ö (letter "o" with umlaut or diaeresis ; "o-umlaut")

ascii code 149 ò (letter "o" with grave accent)

ascii code 150 û (letter "u" with circumflex accent or "u-circumflex")

ascii code 151 ù (letter "u" with grave accent)

ascii code 152 ÿ (letter "y" with diaeresis)

ascii code 153 Ö (letter "O" with umlaut or diaeresis ; "O-umlaut")

ascii code 154 Ü (letter "U" with umlaut or diaeresis ; "U-umlaut")

ascii code 155 ø (slashed zero or empty set)

ascii code 156 £ (Pound sign ; symbol for the pound sterling)

ascii code 157 Ø (slashed zero or empty set)

ascii code 158 × (multiplication sign)

ascii code 159 ƒ (function sign ; f with hook sign ; florin sign )

ascii code 160 á (letter "a" with acute accent or "a-acute")

ascii code 161 í (letter "i" with acute accent or "i-acute")

ascii code 162 ó (letter "o" with acute accent or "o-acute")

ascii code 163 ú (letter "u" with acute accent or "u-acute")

ascii code 164 ñ (letter "n" with tilde ; enye)

ascii code 165 Ñ (letter "N" with tilde ; enye)

ascii code 166 ª (feminine ordinal indicator )

ascii code 167 º (masculine ordinal indicator)

ascii code 168 ¿ (Inverted question marks)

ascii code 169 ® (Registered trademark symbol)

ascii code 170 ¬ (Logical negation symbol)

ascii code 171 ½ (One half)

ascii code 172 ¼ (Quarter or one fourth)

ascii code 173 ¡ (Inverted exclamation marks)

ascii code 174 « (Guillemets or angle quotes)

ascii code 175 » (Guillemets or angle quotes)

ascii code 176 ░

ascii code 177 ▒

ascii code 178 ▓

ascii code 179 │ (Box drawing character)

ascii code 180 ┤ (Box drawing character)

ascii code 181 Á (Capital letter "A" with acute accent or "A-acute")

ascii code 182 Â (letter "A" with circumflex accent or "A-circumflex")

ascii code 183 À (letter "A" with grave accent)

ascii code 184 © (Copyright symbol)

ascii code 185 ╣ (Box drawing character)

ascii code 186 ║ (Box drawing character)

ascii code 187 ╗ (Box drawing character)

ascii code 188 ╝ (Box drawing character)

ascii code 189 ¢ (Cent symbol)

ascii code 190 ¥ (YEN and YUAN sign)

ascii code 191 ┐ (Box drawing character)

ascii code 192 └ (Box drawing character)

ascii code 193 ┴ (Box drawing character)

ascii code 194 ┬ (Box drawing character)

ascii code 195 ├ (Box drawing character)

ascii code 196 ─ (Box drawing character)

ascii code 197 ┼ (Box drawing character)

ascii code 198 ã (letter "a" with tilde or "a-tilde")

ascii code 199 Ã (letter "A" with tilde or "A-tilde")

ascii code 200 ╚ (Box drawing character)

ascii code 201 ╔ (Box drawing character)

ascii code 202 ╩ (Box drawing character)

ascii code 203 ╦ (Box drawing character)

ascii code 204 ╠ (Box drawing character)

ascii code 205 ═ (Box drawing character)

ascii code 206 ╬ (Box drawing character)

ascii code 207 ¤ (generic currency sign )

ascii code 208 ð (lowercase "eth")

ascii code 209 Ð (Capital letter "Eth")

ascii code 210 Ê (letter "E" with circumflex accent or "E-circumflex")

ascii code 211 Ë (letter "E" with umlaut or diaeresis ; "E-umlaut")

ascii code 212 È (letter "E" with grave accent)

ascii code 213 ı (lowercase dot less i)

ascii code 214 Í (Capital letter "I" with acute accent or "I-acute")

ascii code 215 Î (letter "I" with circumflex accent or "I-circumflex")

ascii code 216 Ï (letter "I" with umlaut or diaeresis ; "I-umlaut")

ascii code 217 ┘ (Box drawing character)

ascii code 218 ┌ (Box drawing character)

ascii code 219 █ (Block)

ascii code 220 ▄

ascii code 221 ¦ (vertical broken bar )

ascii code 222 Ì (letter "I" with grave accent)

ascii code 223 ▀

ascii code 224 Ó (Capital letter "O" with acute accent or "O-acute")

ascii code 225 ß (letter "Eszett" ; "scharfes S" or "sharp S")

ascii code 226 Ô (letter "O" with circumflex accent or "O-circumflex")

ascii code 227 Ò (letter "O" with grave accent)

ascii code 228 õ (letter "o" with tilde or "o-tilde")

ascii code 229 Õ (letter "O" with tilde or "O-tilde")

ascii code 230 µ (Lowercase letter "Mu" ; micro sign or micron)

ascii code 231 þ (capital letter "Thorn")

ascii code 232 Þ (lowercase letter "thorn")

ascii code 233 Ú (Capital letter "U" with acute accent or "U-acute")

ascii code 234 Û (letter "U" with circumflex accent or "U-circumflex")

ascii code 235 Ù (letter "U" with grave accent)

ascii code 236 ý (letter "y" with acute accent)

ascii code 237 Ý (Capital letter "Y" with acute accent)

ascii code 238 ¯ (macron symbol)

ascii code 239 ´ (Acute accent)

ascii code 240 ¬ (Hyphen)

ascii code 241 ± (Plus-minus sign)

ascii code 242 ‗ (underline or underscore)

ascii code 243 ¾ (three quarters)

ascii code 244 ¶ (paragraph sign or pilcrow)

ascii code 245 § (Section sign)

ascii code 246 ÷ (The division sign ; Obelus)

ascii code 247 ¸ (cedilla)

ascii code 248 ° (degree symbol )

ascii code 249 ¨ (Diaeresis)

ascii code 250 • (Interpunct or space dot)

ascii code 251 **¹** (superscript one)

ascii code 252 **³** (cube or superscript three)

ascii code 253 **²** (Square or superscript two)

ascii code 254 **■** (black square)

ascii code 255 **nbsp** (non-breaking space or no-break space)

Green = Allowed characters

Red = Disallowed characters

> <span id="_Toc46407960" class="anchor"></span>**Annex Z: How
> Conversion/Validation Handles Excel Formulas**
>
> <span id="_Toc46407961" class="anchor"></span>**1.1 Formulas in
> External Parameter Sheet**

Conversion and Validation application do not support custom destinations
denoted in an external parameter sheet with the use of formulas, in
excel files.

> <span id="_Toc46407962" class="anchor"></span>**1.2 Manual Formulas
> Calculation Detection**

Conversion and Validation do not support detection of event specifying
manual formulas calculation in excel files. The following flags
“Application.calculation = VbManual”, “Application.EnableEvents =
false”, are not supported from Excel Readers.
