package org.fujure.fbc.aast

import org.fujure.fbc.ast.InputFile
import org.fujure.fbc.ast.Module

class AFileContents(val inputFile: InputFile, val module: Module, val defs: List<ADef>)
